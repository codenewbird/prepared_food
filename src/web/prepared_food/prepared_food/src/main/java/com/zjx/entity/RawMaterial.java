package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class RawMaterial {
    private String name;
    private String vendor;
    private String origin;
    private Date buy_time;
    private String store;

    public RawMaterial(String name, String vendor, String origin, Date buy_time, String store) {
        this.name = name;
        this.vendor = vendor;
        this.origin = origin;
        this.buy_time = buy_time;
        this.store = store;
    }
}
