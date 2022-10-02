package com.javarush.task.task13.task1317;

/* 
The weather is fine



Requirements:

3. Тип возвращаемого значения метода getWeatherType должен быть String.
4. Метод getWeatherType должен возвращать значение переменной type.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Today(WeatherType.CLOUDY));
        System.out.println(new Today(WeatherType.FOGGY));
        System.out.println(new Today(WeatherType.FREEZING));
    }

    static class Today implements Weather,WeatherType {
        private String type;

        Today(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("Today it will be %s", this.getWeatherType());
        }

        public String getWeatherType(){
           return type;
            /*if (type.equalsIgnoreCase(WeatherType.CLOUDY))
            return WeatherType.CLOUDY;
            else if (type.equalsIgnoreCase(WeatherType.FOGGY)) {
                return WeatherType.FOGGY;
            } else if(type.equalsIgnoreCase(WeatherType.FREEZING)) {
                return WeatherType.FREEZING;
            }
            else return null;*/
        };

    }
}

