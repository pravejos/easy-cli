package com.github.pravejos.easycli;

import java.lang.reflect.Field;
import java.util.*;

class HelpTextGenerator {
    static String generateHelpText(Class<?> argClass) {
    StringBuilder help = new StringBuilder("Usage: java [JavaOptions] <mainclass> [OPTIONS] [PARAMETERS]\n"
            + "   or  java [JavaOptions] -jar <jarfile> [OPTIONS] [PARAMETERS]\n\n"
            + "Options:\n");
        int maxLongNameLength = 0;

        List<Option> options = new ArrayList<>();
        List<Parameter> parameters = new ArrayList<>();

        for (Field field : argClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Option.class)) {
                Option argumentDef = field.getAnnotation(Option.class);
                options.add(argumentDef);
                argumentDef.longName();
                maxLongNameLength = Math.max(maxLongNameLength, argumentDef.longName().length());
            } else if (field.isAnnotationPresent(Parameter.class)) {
                Parameter parameter = field.getAnnotation(Parameter.class);
                parameters.add(parameter);
            }
        }


        for (Option option : options) {
            help.append("  ");
            if (option.shortName() != 0) {
                help.append("-").append(option.shortName()).append(", ");
            } else {
                help.append("    ");
            }

            // TODO Printing Enum value.
            if (!"".equals(option.longName())) {
                help.append(String.format("%-" + maxLongNameLength + "s", "--" + option.longName())).append(" ");
            } else {
                help.append(String.format("%" + maxLongNameLength + "s", "")).append(" ");
            }

            help.append(option.desc());

            if (!"".equals(option.defaultValue())) {
                help.append(" (default \"").append(option.defaultValue()).append("\")");
            }
            help.append("\n");
        }

        // Print parameters
        if (!parameters.isEmpty()) {
            help.append("\nParameters:\n");
        }
        for (int i = 0; i<parameters.size(); i++) {
            Parameter parameter = parameters.get(i);
            help.append("  Param");
            help.append(i + 1);
            help.append(parameter.required() ? " (Mandatory) " : " ");
            help.append(parameter.desc());
            if (!"".equals(parameter.defaultValue())) {
                help.append(" (default \"").append(parameter.defaultValue()).append("\")");
            }
            help.append("\n");
        }

        return help.toString();
    }
}
