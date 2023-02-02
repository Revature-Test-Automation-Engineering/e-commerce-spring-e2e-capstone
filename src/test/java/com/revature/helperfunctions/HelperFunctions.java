package com.revature.helperfunctions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.*;

public class HelperFunctions {

    public static void standardWait(WebDriver driver, WebElement elem) {
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(15000))
                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(elem)));
    }

    public static Map<String, String> returnProductButtonValues(WebElement productButton){
        Map<String, String> m = new HashMap<>();
        String prodName = productButton.findElement(By.xpath("//h5")).getText();
        m.put("productName", prodName);
        String prodPrice = productButton.findElement(By.xpath("//h6")).getText();
        m.put("productPrice", prodPrice);
        return m;
    }

    //return all info(minus description) in an order card. Pass one order element to get back values as map by key (same as text on order card before ":")
    public static Map<String, String> returnOrderInfo(WebElement order){
        Map<String, String> m = new HashMap<>();
        String orderItemName = order.findElement(By.xpath("//a/p")).getText();
        m.put("orderItem", orderItemName);
        String orderDateInfo = order.findElement(By.xpath("//p[contains(text(), 'date')]")).getText();
        orderDateInfo = orderDateInfo.substring(orderDateInfo.indexOf(":") + 1);
        m.put("orderDate", orderDateInfo);
        String orderTotalInfo = order.findElement(By.xpath("//p[contains(text(), 'total')]")).getText();
        orderTotalInfo = orderTotalInfo.substring(orderTotalInfo.indexOf("$") + 1);
        m.put("orderTotal", orderTotalInfo);
        String orderDetailIdInfo = order.findElement(By.xpath("//p[contains(text(), 'OrderDetail')]")).getText();
        orderDetailIdInfo = orderDetailIdInfo.substring(orderDetailIdInfo.indexOf(":") + 1);
        m.put("orderDetailId", orderDetailIdInfo);
        String orderIdInfo = order.findElement(By.xpath("//p[contains(text(), 'Order ID')]")).getText();
        orderIdInfo = orderIdInfo.substring(orderIdInfo.indexOf(":") + 1);
        m.put("orderId", orderIdInfo);
        String orderQuantityInfo = order.findElement(By.xpath("//p[contains(text(), 'OrderDetail')]")).getText();
        orderQuantityInfo = orderQuantityInfo.substring(orderQuantityInfo.indexOf(":") + 1);
        m.put("orderQuantity", orderQuantityInfo);
        String orderProductIdInfo  = order.findElement(By.xpath("//p[contains(text(), 'OrderDetail')]")).getText();
        orderProductIdInfo = orderProductIdInfo.substring(orderProductIdInfo.indexOf(":") + 1);
        m.put("orderProductId", orderProductIdInfo);
        return m;
    }

    public static List<Email> getEmails() {
        try {
            URL obj = new URL("https://mailtrap.io/api/accounts/1470429/inboxes/2084130/messages");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("API-Token", "d6ef45e0d4812c01773811016a747492");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper objectMapper = new ObjectMapper();
                List<Email> messages = objectMapper.readValue(response.toString(), new TypeReference<List<Email>>() {});
                return messages;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static String getLastLineEmailContent(long emailId) {
        try {
            URL obj = new URL("https://mailtrap.io/api/accounts/1470429/inboxes/2084130/messages/" + emailId + "/body.txt");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("API-Token", "d6ef45e0d4812c01773811016a747492");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                String response = "";

                while ((inputLine = in.readLine()) != null) {
                    response = inputLine;
                }
                in.close();

                return response;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static int getNumberOfEmails() {
        List<Email> emails = getEmails();

        if (emails == null) {
            return 0;
        }

        return emails.size();
    }

    public static String getMostRecentEmailLink() {
        List<Email> emails = getEmails();

        if (emails == null || emails.size() == 0)
            return null;

        return getLastLineEmailContent(emails.get(0).getId());
    }
}

@JsonIgnoreProperties(ignoreUnknown=true)
class Email {
    private long id;
    private long inbox_id;
    private String subject;
    private String from_email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInbox_id() {
        return inbox_id;
    }

    public void setInbox_id(long inbox_id) {
        this.inbox_id = inbox_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom_email() {
        return from_email;
    }

    public void setFrom_email(String from_email) {
        this.from_email = from_email;
    }
}
