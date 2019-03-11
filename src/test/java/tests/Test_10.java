package tests;
/*
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class Test_10 extends MyTestSupport {
    @Test
    public void myFirstTest() throws Exception{
        driver.get("http://localhost/litecart/en/");
        waitXpath("//li[contains(@class,'product')]");
        WebElement campaignsFirst = driver.findElement(By.xpath("(//div[@id='box-campaigns' and @class='box']/div/ul/li)[1]"));
        String mainName = campaignsFirst.findElement(By.xpath(".//div[@class='name']")).getText();
        String mainRegilar = campaignsFirst.findElement(By.xpath(".//div[@class='price-wrapper']/*[@class='regular-price']")).getText();
        String mainCampaign = campaignsFirst.findElement(By.xpath(".//div[@class='price-wrapper']/*[@class='campaign-price']")).getText();
        //обычная цена зачёркнутая и серая
        if(campaignsFirst.findElement(By.xpath(".//div[@class='price-wrapper']/*[@class='regular-price']")).getTagName().equals("s")){
            System.out.println("Успешно! Обычная цена на главной странице зачеркнута");
        }
        else {
            System.out.println("Ошибка! Обычная цена на главной странице не зачеркнута");
        }
        //Проверка цвета основной цены на главной
        Object regularColor = campaignsFirst.findElement(By.xpath(".//div[@class='price-wrapper']/*[@class='regular-price']")).getCssValue("color");
        String[] rcMain = ((String) regularColor).replace("rgba(", "").replace("rgb(", "").replace(")", "").replace(" ", "").split(",");
        if (rcMain[0].equals(rcMain[1]) && rcMain[1].equals(rcMain[2])) {
            System.out.println("Успешно! Цвет основной цены на главной странице серый");
        }
        else {
            System.out.println("Ошибка! Цвет основной цены на главной странице не серый");
        }
        // проверка скидочной цены - жирная
        if(campaignsFirst.findElement(By.xpath(".//div[@class='price-wrapper']/*[@class='campaign-price']")).getTagName().equals("strong")){
            System.out.println("Успешно! Скидочная цена на главной странице жирная");
        }
        else {
            System.out.println("Ошибка! Скидочная цена на главной странице не жирная");
        }
        //Проверка цвета скидочной цены на главной
        Object campaignColor = campaignsFirst.findElement(By.xpath(".//div[@class='price-wrapper']/*[@class='campaign-price']")).getCssValue("color");
        String[] сcMain = ((String) campaignColor).replace("rgba(", "").replace("rgb(", "").replace(")", "").replace(" ", "").split(",");
        if (сcMain[1].equals("0") && сcMain[2].equals("0")) {
            System.out.println("Успешно! Цвет скидочной цены на главной странице красный");
        }
        else {
            System.out.println("Ошибка! Цвет скидочной цены на главной странице не красный");
        }
        // проверка размера цен на главной
        int regOffsetHeight = Integer.parseInt(campaignsFirst.findElement(By.xpath(".//div[@class='price-wrapper']/*[@class='regular-price']")).getAttribute("offsetHeight"));
        int camOffsetHeight = Integer.parseInt(campaignsFirst.findElement(By.xpath(".//div[@class='price-wrapper']/*[@class='campaign-price']")).getAttribute("offsetHeight"));

        if (regOffsetHeight < camOffsetHeight){
            System.out.println("Успешно! Скидочная цена крупнее на главной странице, чем обычная");
        }
        else {
            System.out.println("Ошибка! Обычная цена крупнее на главной странице, чем скидочная");
        }
        // переход к странице товара
        campaignsFirst.click();

        // проверка наименования товара
        if (!mainName.equals(driver.findElement(By.xpath("//h1")).getText())){
            System.out.println("Ошибка! Наименование товара не совпадает");
        }
        else {
            System.out.println("Успешно! Наименование товара совпадает");
        }
        // проверка обычной цены товара
        if (!mainRegilar.equals(driver.findElement(By.xpath("//div[@class='price-wrapper']/*[@class='regular-price']")).getText())){
            System.out.println("Ошибка! Основная цена товара не совпадает");
        }
        else {
            System.out.println("Успешно! Основная цена товара совпадает");
        }
        // проверка скидочной цены товара
        if (!mainCampaign.equals(driver.findElement(By.xpath("//div[@class='price-wrapper']/*[@class='campaign-price']")).getText())){
            System.out.println("Ошибка! Скидочная цена товара не совпадает");
        }
        else {
            System.out.println("Успешно! Скидочная цена товара совпадает");
        }


        if(driver.findElement(By.xpath("//div[@class='price-wrapper']/*[@class='regular-price']")).getTagName().equals("s")){
            System.out.println("Успешно! Обычная цена на странице товара зачеркнута");
        }
        else {
            System.out.println("Ошибка! Обычная цена на странице товара не зачеркнута");
        }
        //Проверка цвета основной цены
        Object regularColorCur = driver.findElement(By.xpath("//div[@class='price-wrapper']/*[@class='regular-price']")).getCssValue("color");
        String[] rcMainCur = ((String) regularColorCur).replace("rgba(", "").replace("rgb(", "").replace(")", "").replace(" ", "").split(",");
        if (rcMainCur[0].equals(rcMainCur[1]) && rcMainCur[1].equals(rcMainCur[2])) {
            System.out.println("Успешно! Цвет основной цены на странице товара серый");
        }
        else {
            System.out.println("Ошибка! Цвет основной цены на странице товара не серый");
        }
        // проверка скидочной цены - жирная
        if(driver.findElement(By.xpath("//div[@class='price-wrapper']/*[@class='campaign-price']")).getTagName().equals("strong")){
            System.out.println("Успешно! Скидочная цена на странице товара жирная");
        }
        else {
            System.out.println("Ошибка! Скидочная цена на странице товара не жирная");
        }
        //Проверка цвета скидочной цены на главной
        Object campaignColorСur = driver.findElement(By.xpath("//div[@class='price-wrapper']/*[@class='campaign-price']")).getCssValue("color");
        String[] сcMainc = ((String) campaignColorСur).replace("rgba(", "").replace("rgb(", "").replace(")", "").replace(" ", "").split(",");
        if (сcMainc[1].equals("0") && сcMainc[2].equals("0")) {
            System.out.println("Успешно! Цвет скидочной цены на странице товара красный");
        }
        else {
            System.out.println("Ошибка! Цвет скидочной цены на странице товара не красный");
        }
        // проверка размера цен на главной
        int regOffsetHeightC = Integer.parseInt(driver.findElement(By.xpath("//div[@class='price-wrapper']/*[@class='regular-price']")).getAttribute("offsetHeight"));
        int camOffsetHeightC = Integer.parseInt(driver.findElement(By.xpath("//div[@class='price-wrapper']/*[@class='campaign-price']")).getAttribute("offsetHeight"));

        if (regOffsetHeightC < camOffsetHeightC){
            System.out.println("Успешно! Скидочная цена крупнее на странице товара, чем обычная");
        }
        else {
            System.out.println("Ошибка! Обычная цена крупнее на странице товара, чем скидочная");
        }

    }
}*/
