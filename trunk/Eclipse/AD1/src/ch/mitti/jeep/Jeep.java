package ch.mitti.jeep;
 
public class Jeep {
       double tankfüllung;
       double verbrauch;
       double tankfüllungenAnLager;
       double maxDistanzProTank;
      
       public Jeep(double tankfüllung, double verbrauch, double tankfüllungenAnLager){
             this.tankfüllung = tankfüllung;
             this.verbrauch = verbrauch;
             this.tankfüllungenAnLager = tankfüllungenAnLager;
             this.maxDistanzProTank = tankfüllung/(verbrauch/100);
             System.out.println("Resultat:"+(Math.round(maxEntfernung(tankfüllungenAnLager))));
       }
      
      
       public double maxEntfernung(double k){
             double res;
             if(k==1){
                    res = maxDistanzProTank;
                    return res;
             }
             else{
                    res = maxDistanzProTank/(2*k-1) + maxEntfernung(k-1);
                    return res;
             }
       }
 
       public static void main(String[] args) {
             //Jeep mit 60 Liter Tank und einem Verbrauch von 10L/100km. Im Tanklager befinden sich 4 Tankladungen (240L)
             Jeep jeep = new Jeep(60.0, 10.0, 6.0);
       }
 
}
 
/* *** Aufgabenstellung **
Ein Fahrer möchte mit seinem Jeep eine Wüste durchqueren, in der es keine Tanklager gibt. Der
Fahrer startet an einem Punkt, an dem sich ein grosses Tanklager befindet. Er steht nun vor der Aufgabe, sich in
der Wüste selber Tanklager anzulegen, auf die er später zurückgreifen kann.
 
Der Jeep hat eine Tankkapazität von c Litern und einen Verbrauch von v Litern pro 100km. Der Fahrer verfolgt
bei der Durchquerung folgende Strategie: Er fährt vom Ausgangspunkt A zum Punkt B und lässt dort genau soviel
Treibstoff aus, dass er mnoch zurück zum Pink A fahren kann. Dann füllt er im Punkt A den Tank wieder auf und
wiederholt das Verfahren solange, bis das Tanklager im Punkt A leer ist. Der Fahrer überlegt sich, dass das
Lager B genauso weit entfernt ist, dass durch mehrmaliges hin- und herfahren eine Tankfüllung verbraucht wird
Daraus folgt, dass im Tanklager B
 
       k-1 Tankfüllungen vorhanden sind (Im Lager C k-2)
 
Bestimmen Sie nun die maximale Entfernung, welche mit k Tankfüllungen bei einer Tankkapazität c und dem
Verbrauch v auf diese Weise zurückgelegt werden kann.
*/