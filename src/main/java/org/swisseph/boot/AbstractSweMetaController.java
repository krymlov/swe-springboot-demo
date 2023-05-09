package org.swisseph.boot;

import org.springframework.beans.factory.annotation.Value;
import org.swisseph.SwephNative;

import java.util.Calendar;

import static java.util.TimeZone.getTimeZone;

/**
 * @author Yura Krymlov
 * @version 1.0, 2023-05
 */
public abstract class AbstractSweMetaController {

    @Value("${ephe.path}")
    protected String ephePath;

    protected SwephNative newSwephExp() {
        return new SwephNative(ephePath);
    }

    protected Calendar newCalendar(String timeZoneID) {
        return Calendar.getInstance(getTimeZone(timeZoneID));
    }
}
