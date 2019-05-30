package com.vadym.lopatka.interestingTasks.test3;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        openAndClosePrices("1-January-2000", "22-February-2000", "Monday");
    }

    private static final String BASE_LINK = "https://jsonmock.hackerrank.com/api/stocks";

    /*
     * Not the most effective but easy and readable way to implement this logic
     */
    static void openAndClosePrices(final String firstDate, final String lastDate, final String weekDay) {

        List<StockDay> stockDays;
        try {
            stockDays = getData();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);

        /**
         * Here I have all stock days in memory but it is impossible
         * to use parallelStream as SimpleDateFormat is not thread safe
         */
        stockDays.stream()
                .filter(stockDay -> isDateMatchesWeekday(stockDay.getDate(), weekDay, dateFormat, dayFormat))
                .filter(stockDay -> isDateBetweenDates(stockDay.getDate(), dateFormat, firstDate, lastDate))
                .map(day -> day.getDate() + " " + day.getOpen() + " " + day.getClose())
                .forEach(System.out::println);
    }

    /**
     * Checking if a stock date is between first and last dates
     *
     * @param date
     * @param dateFormat
     * @param firstDateString
     * @param lastDateString
     * @return
     */
    private static boolean isDateBetweenDates(String date, SimpleDateFormat dateFormat, String firstDateString, String lastDateString) {
        try {
            Date stockDate = dateFormat.parse(date);
            Date firstDate = dateFormat.parse(firstDateString);
            Date lastDate = dateFormat.parse(lastDateString);

            //return firstDate.compareTo(stockDate) * stockDate.compareTo(lastDate) >= 0; // inclusive range
            return stockDate.after(firstDate) && stockDate.before(lastDate);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checking if a stock date matches a needed weekday
     *
     * @param stockDate
     * @param weekDay
     * @param dateFormat
     * @param dayFormat
     * @return
     */
    private static boolean isDateMatchesWeekday(String stockDate, String weekDay, SimpleDateFormat dateFormat, SimpleDateFormat dayFormat) {
        try {
            String stockDayAsDayOfWeek = dayFormat.format(dateFormat.parse(stockDate));
            return stockDayAsDayOfWeek.equals(weekDay);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @return - List of StockDays where a StockDay represent the stock market info of this day
     * @throws IOException
     */
    private static List<StockDay> getData() throws IOException {
        String mainPage = getDataFromUrl(BASE_LINK);
        Gson gson = new Gson();
        StockResponse response = gson.fromJson(mainPage, StockResponse.class);

        //create accumulator
        List<StockDay> stockDays = new ArrayList<>(response.getTotal());

        //add first part of the data that was given
        stockDays.addAll(Arrays.asList(response.getData()));

        // add other parts of the data
        for (int pageNumber = response.getTotal_pages(); pageNumber > 1; pageNumber--) {
            response = gson.fromJson(getDataFromUrl(BASE_LINK + "?page=" + pageNumber), StockResponse.class);
            stockDays.addAll(Arrays.asList(response.getData()));
        }

        return stockDays;
    }

    /**
     *
     * @param link - URL that will be visited
     * @return - Json string
     * @throws IOException
     */
    private static String getDataFromUrl(String link) throws IOException {
        URL obj = new URL(link);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    private class StockResponse implements Serializable {
        private static final long serialVersionUID = 1L;

        private int page;
        private int per_page;
        private int total;
        private int total_pages;
        private StockDay[] data;

        public StockResponse() {
        }

        public StockResponse(int page, int per_page, int total, int total_pages, StockDay[] data) {
            this.page = page;
            this.per_page = per_page;
            this.total = total;
            this.total_pages = total_pages;
            this.data = data;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public StockDay[] getData() {
            return data;
        }

        public void setData(StockDay[] data) {
            this.data = data;
        }
    }

    private class StockDay implements Serializable {
        private static final long serialVersionUID = 1L;

        private String date;
        private double open;
        private double close;

        public StockDay() {
        }

        public StockDay(String date, double open, double close) {
            this.date = date;
            this.open = open;
            this.close = close;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getOpen() {
            return open;
        }

        public void setOpen(double open) {
            this.open = open;
        }

        public double getClose() {
            return close;
        }

        public void setClose(double close) {
            this.close = close;
        }
    }
}
