package org.swisseph.boot.kyiv;

import org.jyotisa.api.IKundali;
import org.jyotisa.meta.api.IMetaJyotisa;
import org.jyotisa.meta.api.IMetaJyotisaBuilder;
import org.jyotisa.meta.event.MetaDateTime;
import org.jyotisa.meta.event.MetaEntity;
import org.jyotisa.meta.event.MetaLocation;
import org.swisseph.api.ISweGeoLocation;
import org.swisseph.api.ISweJulianDate;
import org.swisseph.app.SweGeoLocation;

import static org.swisseph.utils.IDateUtils.*;
import static org.swisseph.utils.IDateUtils.format6;
import static org.swisseph.utils.IDegreeUtils.toLAT;
import static org.swisseph.utils.IDegreeUtils.toLON;

/**
 * @author Yura Krymlov
 * @version 1.0, 2023-05
 */
public interface ISweMetaKyivConfig extends IMetaJyotisaBuilder {
    String EUROPE_KIEV = "Europe/Kiev";

    /**
     * Place : Kyiv, Ukraine<br>
     * Location : 50°27'N, 30°31'E. Time Zone : (+02:00)
     */
    ISweGeoLocation GEO_KYIV = new SweGeoLocation(30 + (31 / 60.), 50 + (27 / 60.), 180);

    @Override
    default void addMetaEventInfo(IMetaJyotisa jyotisa, IKundali kundali) {
        final ISweJulianDate date = kundali.sweJulianDate();
        final int year = date.year();

        MetaLocation location = jyotisa.event().location();
        ISweGeoLocation sweLocation = kundali.sweLocation();
        location.lat(toLAT(sweLocation.latitude()).toString());
        location.lon(toLON(sweLocation.longitude()).toString());

        location.name("Київ, Україна");
        location.text(location.name() + " (" + location.lat() + ", " + location.lon() + ")");

        MetaDateTime datetime = jyotisa.event().datetime();
        datetime.date(format(date, F4Y_2M_2D).toString());
        datetime.time(format(date, F2H_2M_2S).toString());
        datetime.zone("(UTC+" + date.timeZone() + ")");
        datetime.name(format6(date).toString());

        MetaEntity entity = jyotisa.event().entity();
        entity.text("Київ " + datetime.name());
        entity.name("Київ " + year);
    }
}
