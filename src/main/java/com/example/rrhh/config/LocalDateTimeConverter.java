package com.example.rrhh.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true) // <- Esto hace que aplique a TODOS los LocalDateTime de tu app automáticamente
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, String> {

    // Aquí defines el formato exacto que quieres ver en SQLite
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String convertToDatabaseColumn(LocalDateTime localDateTime) {
        // Cuando Java guarda en la Base de Datos: Convierte LocalDateTime a String
        return localDateTime != null ? localDateTime.format(FORMATTER) : null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String dbData) {
        // Cuando Java lee de la Base de Datos: Convierte String a LocalDateTime
        return dbData != null ? LocalDateTime.parse(dbData, FORMATTER) : null;
    }
}
