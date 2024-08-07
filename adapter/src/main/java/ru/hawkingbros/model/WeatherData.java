package ru.hawkingbros.model;

import lombok.Data;

@Data
public class WeatherData {
    private String kind;
    private DateTime date;
    private Temperature temperature;
    private String description;
    private int humidity;
    private Pressure pressure;
    private Cloudiness cloudiness;
    private Precipitation precipitation;
    private Wind wind;

    @Data
    public static class DateTime {
        private String UTC;
        private long unix;
        private String local;
        private int time_zone_offset;
    }

    @Data
    public static class Temperature {
        private Air air;
        private Comfort comfort;

        @Data
        public static class Air {
            private float C;
        }

        @Data
        public static class Comfort {
            private float C;
        }
    }

    @Data
    public static class Pressure {
        private int mm_hg_atm;
    }

    @Data
    public static class Cloudiness {
        private int percent;
        private int type;
    }

    @Data
    public static class Precipitation {
        private int type;
        private Float amount;
        private int intensity;
    }

    @Data
    public static class Wind {
        private Direction direction;
        private Speed speed;

        @Data
        public static class Direction {
            private int degree;
            private int scale_8;
        }

        @Data
        public static class Speed {
            private float m_s;
        }
    }
}
