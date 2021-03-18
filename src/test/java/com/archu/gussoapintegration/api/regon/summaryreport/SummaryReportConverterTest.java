package com.archu.gussoapintegration.api.regon.summaryreport;

import com.archu.gussoapintegration.api.regon.summaryreport.dto.SummaryReportBaseDTO;
import com.archu.gussoapintegration.integration.regon.summaryreport.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SummaryReportConverterTest {

    @InjectMocks
    private SummaryReportConverter summaryReportConverter;


    private final NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.NowePodmiotyPrawneOrazDzialalnosciOsFizycznychData
            nowePodmiotyPrawneOrazDzialalnosciOsFizycznychData =
            new NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.NowePodmiotyPrawneOrazDzialalnosciOsFizycznychData();

    private final AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData
            aktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData =
            new AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData();

    private final SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData
            skreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData = new SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData();

    private final NoweJednostkiLokalneRoot.NoweJednostkiLokalneData noweJednostkiLokalneData = new NoweJednostkiLokalneRoot.NoweJednostkiLokalneData();

    private final AktualizowaneJednostkiLokalneRoot.AktualizowaneJednostkiLokalneData aktualizowaneJednostkiLokalneData
            = new AktualizowaneJednostkiLokalneRoot.AktualizowaneJednostkiLokalneData();

    private final SkresloneJednostkiLokalneRoot.SkresloneJednostkiLokalneData skresloneJednostkiLokalneData
            = new SkresloneJednostkiLokalneRoot.SkresloneJednostkiLokalneData();

    private final SummaryReportBaseDTO summaryReportBaseDtoWithSpecifiedValues = new SummaryReportBaseDTO("1234567891");

    private final SummaryReportBaseDTO summaryReportBaseDtoWithNullValues = new SummaryReportBaseDTO(null);


    @Test
    @DisplayName("Converting valid NowePodmiotyPrawneOrazDzialalnosciOsFizycznychData values to valid DTO")
    public void testConvertNowePodmiotyPrawneOrazDzialalnosciOsFizycznychDataWhenValuesAreValid() {
        nowePodmiotyPrawneOrazDzialalnosciOsFizycznychData.setRegon("1234567891");
        var result = summaryReportConverter.convert(nowePodmiotyPrawneOrazDzialalnosciOsFizycznychData);
        assertEquals(summaryReportBaseDtoWithSpecifiedValues, result);
    }

    @Test
    @DisplayName("Converting blank NowePodmiotyPrawneOrazDzialalnosciOsFizycznychData values to nulls")
    public void testConvertNowePodmiotyPrawneOrazDzialalnosciOsFizycznychDataWhenBlankValuesAreProvided() {
        nowePodmiotyPrawneOrazDzialalnosciOsFizycznychData.setRegon("");
        var result = summaryReportConverter.convert(nowePodmiotyPrawneOrazDzialalnosciOsFizycznychData);

        assertEquals(summaryReportBaseDtoWithNullValues, result);
    }

    @Test
    @DisplayName("Converting valid AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData values to valid DTO")
    public void testConvertAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychDataWhenValuesAreValid() {
        aktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData.setRegon("1234567891");
        var result = summaryReportConverter.convert(aktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData);
        assertEquals(summaryReportBaseDtoWithSpecifiedValues, result);
    }

    @Test
    @DisplayName("Converting blank AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData values to nulls")
    public void testConvertAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychDataWhenBlankValuesAreProvided() {
        aktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData.setRegon("");
        var result = summaryReportConverter.convert(aktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData);

        assertEquals(summaryReportBaseDtoWithNullValues, result);
    }

    @Test
    @DisplayName("Converting valid SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData values to valid DTO")
    public void testConvertSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychDataWhenValuesAreValid() {
        skreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData.setRegon("1234567891");
        var result = summaryReportConverter.convert(skreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData);
        assertEquals(summaryReportBaseDtoWithSpecifiedValues, result);
    }

    @Test
    @DisplayName("Converting blank SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData values to nulls")
    public void testConvertSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychDataWhenBlankValuesAreProvided() {
        skreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData.setRegon("");
        var result = summaryReportConverter.convert(skreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData);

        assertEquals(summaryReportBaseDtoWithNullValues, result);
    }

    @Test
    @DisplayName("Converting valid NoweJednostkiLokalneData values to valid DTO")
    public void testConvertNoweJednostkiLokalneDataWhenValuesAreValid() {
        noweJednostkiLokalneData.setRegon("1234567891");
        var result = summaryReportConverter.convert(noweJednostkiLokalneData);
        assertEquals(summaryReportBaseDtoWithSpecifiedValues, result);
    }

    @Test
    @DisplayName("Converting blank NoweJednostkiLokalneData values to nulls")
    public void testConvertNoweJednostkiLokalneDataWhenBlankValuesAreProvided() {
        noweJednostkiLokalneData.setRegon("");
        var result = summaryReportConverter.convert(noweJednostkiLokalneData);

        assertEquals(summaryReportBaseDtoWithNullValues, result);
    }

    @Test
    @DisplayName("Converting valid AktualizowaneJednostkiLokalneData values to valid DTO")
    public void testConvertAktualizowaneJednostkiLokalneDataWhenValuesAreValid() {
        aktualizowaneJednostkiLokalneData.setRegon("1234567891");
        var result = summaryReportConverter.convert(aktualizowaneJednostkiLokalneData);
        assertEquals(summaryReportBaseDtoWithSpecifiedValues, result);
    }

    @Test
    @DisplayName("Converting blank AktualizowaneJednostkiLokalneData values to nulls")
    public void testConvertAktualizowaneJednostkiLokalneDataWhenBlankValuesAreProvided() {
        aktualizowaneJednostkiLokalneData.setRegon("");
        var result = summaryReportConverter.convert(aktualizowaneJednostkiLokalneData);

        assertEquals(summaryReportBaseDtoWithNullValues, result);
    }

    @Test
    @DisplayName("Converting valid SkresloneJednostkiLokalneData values to valid DTO")
    public void testConvertSkresloneJednostkiLokalneDataWhenValuesAreValid() {
        skresloneJednostkiLokalneData.setRegon("1234567891");
        var result = summaryReportConverter.convert(skresloneJednostkiLokalneData);
        assertEquals(summaryReportBaseDtoWithSpecifiedValues, result);
    }

    @Test
    @DisplayName("Converting blank SkresloneJednostkiLokalneData values to nulls")
    public void testConvertSkresloneJednostkiLokalneDataWhenBlankValuesAreProvided() {
        skresloneJednostkiLokalneData.setRegon("");
        var result = summaryReportConverter.convert(skresloneJednostkiLokalneData);

        assertEquals(summaryReportBaseDtoWithNullValues, result);
    }

}