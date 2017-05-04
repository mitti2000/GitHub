package ch.mitti.jeep;
 
public class Jeep {
       double tankf�llung;
       double verbrauch;
       double tankf�llungenAnLager;
       double maxDistanzProTank;
      
       public Jeep(double tankf�llung, double verbrauch, double tankf�llungenAnLager){
             this.tankf�llung = tankf�llung;
             this.verbrauch = verbrauch;
             this.tankf�llungenAnLager = tankf�llungenAnLager;
             this.maxDistanzProTank = tankf�llung/(verbrauch/100);
             System.out.println("Resultat:"+(Math.round(maxEntfernung(tankf�llungenAnLager))));
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
Ein Fahrer m�chte mit seinem Jeep eine W�ste durchqueren, in der es keine Tanklager gibt. Der
Fahrer startet an einem Punkt, an dem sich ein grosses Tanklager befindet. Er steht nun vor der Aufgabe, sich in
der W�ste selber Tanklager anzulegen, auf die er sp�ter zur�ckgreifen kann.
 
Der Jeep hat eine Tankkapazit�t von c Litern und einen Verbrauch von v Litern pro 100km. Der Fahrer verfolgt
bei der Durchquerung folgende Strategie: Er f�hrt vom Ausgangspunkt A zum Punkt B und l�sst dort genau soviel
Treibstoff aus, dass er mnoch zur�ck zum Pink A fahren kann. Dann f�llt er im Punkt A den Tank wieder auf und
wiederholt das Verfahren solange, bis das Tanklager im Punkt A leer ist. Der Fahrer �berlegt sich, dass das
Lager B genauso weit entfernt ist, dass durch mehrmaliges hin- und herfahren eine Tankf�llung verbraucht wird
Daraus folgt, dass im Tanklager B
 
       k-1 Tankf�llungen vorhanden sind (Im Lager C k-2)
 
Bestimmen Sie nun die maximale Entfernung, welche mit k Tankf�llungen bei einer Tankkapazit�t c und dem
Verbrauch v auf diese Weise zur�ckgelegt werden kann.
*/