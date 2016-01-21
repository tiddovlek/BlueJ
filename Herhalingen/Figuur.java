public class Figuur {
  private Schildpad schildpad;
  private int x, y;

  /**
  * Maakt een nieuw figuur object
  * (x,y) is de posititie waard het tekenen van de figuur begint
  */

  public Figuur( int x, int y ) {
    schildpad = new Schildpad();
    this.x = x;
    this.y = y;
    schildpad.gaNaar( x, y );
    schildpad.penNeer();
  }
  
  public Figuur() {
    schildpad = new Schildpad();
    schildpad.gaNaar(200, 200);
    schildpad.penNeer();
  }


  public Schildpad getSchildpad() {
    return schildpad;
  }

  public void randomWalk() {
    for (int i = 0; i < 1000; i++) {
        schildpad.penNeer();
        if (Math.random() > 0.75) {schildpad.penOmhoog();}
        
        schildpad.vooruit(Math.random()*20);
        schildpad.draaiRechts(Math.random()*180-90);
        
        catchTurtle();
    }
  }
  
  public void slowRandomWalk() {
    for (int i = 0; i < 1000; i++) {
        schildpad.penNeer();
        if (Math.random() > 0.75) {schildpad.penOmhoog();}
        
        //walk
        int walk = (int)(Math.random()*20);
        for (int iWalk = 0; iWalk < walk; iWalk++) {
            schildpad.vooruit(1);
            schildpad.slaap(1);
        }
        
        //turn
        int right = 0;
        if (Math.random() > 0.5) {
            right = 2;
        }
        else {
            right = -2;
        }
        int turn = (int)(Math.random()*45);
        for (int iTurn = 0; iTurn < turn; iTurn++) {
            schildpad.draaiRechts(right);
            schildpad.slaap(1);
        }
        
        catchTurtle();
    }
  }
  
  public void catchTurtle() {
      if (schildpad.getX() <= 0
      || schildpad.getX() >= 400
      || schildpad.getY() <= 0
      || schildpad.getY() >= 400) {
          schildpad.gaNaar(200, 200);
      }
  }
  
  public void tekenVierkant( int zijde ) {
    for ( int i = 1; i <= 4; i++ ) {
      schildpad.vooruit( zijde );
      schildpad.draaiRechts( 90 );
    }
  }

  public void herhaalVierkant( int zijde ) {
    for ( int i = 1; i <= 36; i++ ) {
      tekenVierkant( zijde );
      schildpad.draaiRechts( 10 );
    }
  }

  public void tekenVeelhoek( int aantalHoeken, int zijde ) {
    for( int i = 1; i <= aantalHoeken; i++ ) {
      schildpad.vooruit( zijde );
      schildpad.draaiLinks( 360.0 / aantalHoeken );
    }
  }

  public void herhaalVeelhoek( int aantalHoeken, int zijde ) {
    for ( int i = 1; i <= 36; i++ ) {
      tekenVeelhoek( aantalHoeken, zijde );
      schildpad.draaiRechts( 10 );
    }
  }

  public void herhaalFiguur( int aantalHoeken, int zijde ) {
    for ( int i = 1; i <= aantalHoeken; i++ ) {
      tekenVeelhoek( aantalHoeken, zijde );
      schildpad.draaiRechts( 360.0 / aantalHoeken );
    }
  }

  public void wisTekening() {
    schildpad.wisTekening();
  }

}
