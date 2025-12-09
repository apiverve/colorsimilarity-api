// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     ColorSimilarityCalculatorData data = Converter.fromJsonString(jsonString);

package com.apiverve.colorsimilarity.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static ColorSimilarityCalculatorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(ColorSimilarityCalculatorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(ColorSimilarityCalculatorData.class);
        writer = mapper.writerFor(ColorSimilarityCalculatorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// ColorSimilarityCalculatorData.java

package com.apiverve.colorsimilarity.data;

import com.fasterxml.jackson.annotation.*;

public class ColorSimilarityCalculatorData {
    private Color color1;
    private Color color2;
    private double rgbDistance;
    private double rgbSimilarity;
    private double hslSimilarity;
    private double overallSimilarity;
    private double deltaE;
    private double hueDifference;
    private long saturationDifference;
    private double lightnessDifference;
    private String similarityCategory;
    private boolean areIdentical;

    @JsonProperty("color1")
    public Color getColor1() { return color1; }
    @JsonProperty("color1")
    public void setColor1(Color value) { this.color1 = value; }

    @JsonProperty("color2")
    public Color getColor2() { return color2; }
    @JsonProperty("color2")
    public void setColor2(Color value) { this.color2 = value; }

    @JsonProperty("rgb_distance")
    public double getRGBDistance() { return rgbDistance; }
    @JsonProperty("rgb_distance")
    public void setRGBDistance(double value) { this.rgbDistance = value; }

    @JsonProperty("rgb_similarity")
    public double getRGBSimilarity() { return rgbSimilarity; }
    @JsonProperty("rgb_similarity")
    public void setRGBSimilarity(double value) { this.rgbSimilarity = value; }

    @JsonProperty("hsl_similarity")
    public double getHslSimilarity() { return hslSimilarity; }
    @JsonProperty("hsl_similarity")
    public void setHslSimilarity(double value) { this.hslSimilarity = value; }

    @JsonProperty("overall_similarity")
    public double getOverallSimilarity() { return overallSimilarity; }
    @JsonProperty("overall_similarity")
    public void setOverallSimilarity(double value) { this.overallSimilarity = value; }

    @JsonProperty("delta_e")
    public double getDeltaE() { return deltaE; }
    @JsonProperty("delta_e")
    public void setDeltaE(double value) { this.deltaE = value; }

    @JsonProperty("hue_difference")
    public double getHueDifference() { return hueDifference; }
    @JsonProperty("hue_difference")
    public void setHueDifference(double value) { this.hueDifference = value; }

    @JsonProperty("saturation_difference")
    public long getSaturationDifference() { return saturationDifference; }
    @JsonProperty("saturation_difference")
    public void setSaturationDifference(long value) { this.saturationDifference = value; }

    @JsonProperty("lightness_difference")
    public double getLightnessDifference() { return lightnessDifference; }
    @JsonProperty("lightness_difference")
    public void setLightnessDifference(double value) { this.lightnessDifference = value; }

    @JsonProperty("similarity_category")
    public String getSimilarityCategory() { return similarityCategory; }
    @JsonProperty("similarity_category")
    public void setSimilarityCategory(String value) { this.similarityCategory = value; }

    @JsonProperty("are_identical")
    public boolean getAreIdentical() { return areIdentical; }
    @JsonProperty("are_identical")
    public void setAreIdentical(boolean value) { this.areIdentical = value; }
}

// Color.java

package com.apiverve.colorsimilarity.data;

import com.fasterxml.jackson.annotation.*;

public class Color {
    private String hex;
    private RGB rgb;
    private Hsl hsl;

    @JsonProperty("hex")
    public String getHex() { return hex; }
    @JsonProperty("hex")
    public void setHex(String value) { this.hex = value; }

    @JsonProperty("rgb")
    public RGB getRGB() { return rgb; }
    @JsonProperty("rgb")
    public void setRGB(RGB value) { this.rgb = value; }

    @JsonProperty("hsl")
    public Hsl getHsl() { return hsl; }
    @JsonProperty("hsl")
    public void setHsl(Hsl value) { this.hsl = value; }
}

// Hsl.java

package com.apiverve.colorsimilarity.data;

import com.fasterxml.jackson.annotation.*;

public class Hsl {
    private double h;
    private long s;
    private double l;

    @JsonProperty("h")
    public double getH() { return h; }
    @JsonProperty("h")
    public void setH(double value) { this.h = value; }

    @JsonProperty("s")
    public long getS() { return s; }
    @JsonProperty("s")
    public void setS(long value) { this.s = value; }

    @JsonProperty("l")
    public double getL() { return l; }
    @JsonProperty("l")
    public void setL(double value) { this.l = value; }
}

// RGB.java

package com.apiverve.colorsimilarity.data;

import com.fasterxml.jackson.annotation.*;

public class RGB {
    private long r;
    private long g;
    private long b;

    @JsonProperty("r")
    public long getR() { return r; }
    @JsonProperty("r")
    public void setR(long value) { this.r = value; }

    @JsonProperty("g")
    public long getG() { return g; }
    @JsonProperty("g")
    public void setG(long value) { this.g = value; }

    @JsonProperty("b")
    public long getB() { return b; }
    @JsonProperty("b")
    public void setB(long value) { this.b = value; }
}