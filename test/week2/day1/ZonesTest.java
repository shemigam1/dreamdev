package week2.day1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week2.day1.assignment.Zones;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZonesTest {
    @Test
    @DisplayName("Take lagos, expect South West")
    public void lagosIsSouthWest(){
        assertEquals("South West", Zones.getZone("lagos"));
    }

    @Test
    @DisplayName("Take Lagos uppercase, expect South West")
    public void lagosUppercaseIsSouthWest(){
        assertEquals("South West", Zones.getZone("Lagos"));
    }

    @Test
    @DisplayName("Take benue, expect North Central")
    public void benueIsNorthCentral(){
        assertEquals("North Central", Zones.getZone("benue"));
    }

    @Test
    @DisplayName("Take adamawa, expect North East")
    public void adamawaIsNorthEast(){
        assertEquals("North East", Zones.getZone("adamawa"));
    }

    @Test
    @DisplayName("Take kano, expect North West")
    public void kanoIsNorthWest(){
        assertEquals("North West", Zones.getZone("kano"));
    }

    @Test
    @DisplayName("Take enugu, expect South East")
    public void enuguIsSouthEast(){
        assertEquals("South East", Zones.getZone("enugu"));
    }

    @Test
    @DisplayName("Take rivers, expect South South")
    public void riversIsSouthSouth(){
        assertEquals("South South", Zones.getZone("rivers"));
    }

    @Test
    @DisplayName("Take wakanda, expect O.Y.O lo wa")
    public void unknownStateReturnsOYO(){
        assertEquals("O.Y.O lo wa", Zones.getZone("wakanda"));
    }

    @Test
    @DisplayName("Take empty string, expect O.Y.O lo wa")
    public void emptyStringReturnsOYO(){
        assertEquals("O.Y.O lo wa", Zones.getZone(""));
    }

    @Test
    @DisplayName("Take akwa-ibom, expect South South")
    public void akwaIbomIsSouthSouth(){
        assertEquals("South South", Zones.getZone("akwa-ibom"));
    }
}
