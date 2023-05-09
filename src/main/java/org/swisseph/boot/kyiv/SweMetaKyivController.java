package org.swisseph.boot.kyiv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jyotisa.api.IKundali;
import org.jyotisa.app.KundaliBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.swisseph.ISwissEph;
import org.swisseph.app.SweJulianDate;
import org.swisseph.boot.AbstractSweMetaController;

import static org.jyotisa.app.KundaliOptions.KUNDALI_7_KARAKAS;
import static org.swisseph.app.SweObjectsOptions.TRUECITRA_AYANAMSA;

/**
 * @author Yura Krymlov
 * @version 1.0, 2023-05
 */
@RestController
class SweMetaKyivController extends AbstractSweMetaController implements ISweMetaKyivConfig {
    private final ObjectMapper objectMapper;

    public SweMetaKyivController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping(value = "/meta/kyiv", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> metaKyiv() throws JsonProcessingException {
        try (ISwissEph swissEph = newSwephExp()) {
            IKundali kundali = new KundaliBuilder(KUNDALI_7_KARAKAS,
                    swissEph, new SweJulianDate(newCalendar(EUROPE_KIEV)),
                        GEO_KYIV, TRUECITRA_AYANAMSA).completeBuild();

            return ResponseEntity.ok(objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(buildMetaJyotisa(kundali)));
        }
    }

}
