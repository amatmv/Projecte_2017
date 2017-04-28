import java.time.LocalTime;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @class Horari
 * @brief 
 * @details 
 *
 * @author Roger Generoso Masós
 * @version 2017.4.5
 */
public class Horari {
    private Map< Pair<MonthDay,MonthDay>, Pair<LocalTime,LocalTime>> periodesObertura;
    private Map< MonthDay, Pair<MonthDay, MonthDay> > excepcions;

    Horari(){  
        periodesObertura = new TreeMap<>();
        excepcions = new ArrayList<>();
    }

    void afegirAHorariObertura(MonthDay ini, MonthDay fi, LocalTime horaIni, LocalTime horaFi){
        Pair<MonthDay,MonthDay> nouPeriode = new Pair<MonthDay,MonthDay>(ini, fi);
        Pair<LocalTime,LocalTime> nouHorariObertura = new Pair<LocalTime,LocalTime>(horaIni, horFi);
        periodesObertura.put(nouPeriode,nouHorariObertura);
    }

    void afegirExcepio(MonthDay dia, LocalTime horaIni, LocalTime horaFi){
        Pair<LocalTime,LocalTime> horariExecep = new Pair<LocalTime,LocalTime>(horaIni, horFi);
        excepcions.put(dia, horariExecep);
    }


}
