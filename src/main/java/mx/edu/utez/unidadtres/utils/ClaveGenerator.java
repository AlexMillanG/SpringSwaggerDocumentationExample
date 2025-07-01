package mx.edu.utez.unidadtres.utils;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class ClaveGenerator {
    public static String generateCedeClave(Long id){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy",new Locale("es-MX"));
        String formatedDate = simpleDateFormat.format(new Date());
        String randomNumber = String.format("%04d", ThreadLocalRandom.current().nextInt(1,10000));

        return "C"+id+"-"+formatedDate + "-" +randomNumber;
    }



    public static String generateWareHouseClave(String cedeClave, Long idWarehouse ){
        return null;
    }
}
