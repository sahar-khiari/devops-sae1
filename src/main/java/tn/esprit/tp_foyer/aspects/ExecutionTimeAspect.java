package tn.esprit.tp_foyer.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class ExecutionTimeAspect {


    @Around("execution(* tn.esprit.tp_foyer.services.ReservationService.create(..))")
    public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = pjp.proceed(); // Exécuter la méthode réelle

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("⏱️ Temps d’exécution de create() : " + duration + " ms");

        return result;
    }

}
