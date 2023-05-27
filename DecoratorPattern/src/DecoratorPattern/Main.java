package DecoratorPattern;

interface Party {
 void celebrate();
}


class BasicParty implements Party {
 @Override
 public void celebrate() {
     System.out.println("Having a basic party!");
 }
}


abstract class PartyDecorator implements Party {
 protected Party decoratedParty;

 public PartyDecorator(Party decoratedParty) {
     this.decoratedParty = decoratedParty;
 }

 public void celebrate() {
     decoratedParty.celebrate();
 }
}


class BalloonsDecorator extends PartyDecorator {
 public BalloonsDecorator(Party decoratedParty) {
     super(decoratedParty);
 }

 @Override
 public void celebrate() {
     super.celebrate();
     System.out.println("Decorating with colorful balloons!");
 }
}


class MusicDecorator extends PartyDecorator {
 public MusicDecorator(Party decoratedParty) {
     super(decoratedParty);
 }

 @Override
 public void celebrate() {
     super.celebrate();
     System.out.println("Playing lively music!");
 }
}
public class Main {
 public static void main(String[] args) {
     
     Party basicParty = new BasicParty();
     basicParty.celebrate();

     System.out.println("-------------------");

     
     Party balloonsParty = new BalloonsDecorator(basicParty);
     balloonsParty.celebrate();

     System.out.println("-------------------");

     
     Party balloonsMusicParty = new MusicDecorator(new BalloonsDecorator(basicParty));
     balloonsMusicParty.celebrate();
 }
}

