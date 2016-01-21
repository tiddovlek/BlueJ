import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;

/**
 * Klasse voor een virtuele schildpad die kan tekenen, 
 * gebaseerd op de Logo-schildpad van Seymour Papert.
 * @version 3.0
 * @author Gertjan Laan
 */
public class Schildpad {
  private String kleur;
  private boolean verberg;
  private boolean penNeer;
  private ArrayList< Lijn > tekening;

  private final double RAD = Math.PI / 180.0;
  private double xEcht, yEcht,  // werkelijke x- en y van de turtle
                 richting;      // richting van de turtle in graden
  private final double xDefault = 200, yDefault = 200, richtingDefault = 90;
  private static SchildpadVenster venster = null;
  
  /**
   * Constructor voor een schildpad;
   * maakt een schildpad op positie (200, 200) die naar boven kijkt.
   */
  public Schildpad() {
    xEcht = xDefault;
    yEcht = yDefault;
    richting = richtingDefault;
    verberg = false;
    penNeer = false;
    tekening = new ArrayList< Lijn >();
    kleur = "groen";
    toon();
  }

  // Methoden
  // Plaats hieronder de methode tekenVierkant():

  /**
   * Teken een vierkant met zijden van 100px.
   */
  public void tekenVierkant() {
      penNeer();
      for (int i = 0; i < 4; i++) {
          for (int iStep = 0; iStep < 100; iStep++) {
              vooruit(1);
              slaap(5);
          }
          for (int iTurn = 0; iTurn < 90; iTurn++) {
              draaiRechts(1);
              slaap(500/90);
          }
      }
  }
  
  /**
   * Teken een vierkant.
   * @param zijde De lengte van een zijde in px.
   */
  public void tekenVierkant(int zijde) {
      penNeer();
      for (int i = 0; i < 4; i++) {
          for (int iStep = 0; iStep < zijde; iStep++) {
              vooruit(1);
              slaap(5);
          }
          for (int iTurn = 0; iTurn < 90; iTurn++) {
              draaiRechts(1);
              slaap(500/90);
          }
      }
  }
  
  /**
   * Teken een driehoek met zijden van 100 px.
   */
  public void tekenDriehoek() {
      penNeer();
      for (int i = 0; i < 3; i++) {
         for (int iTurn = 0; iTurn < 30; iTurn++) {
             draaiRechts(1);
             slaap(2);
         }
         for (int iStep = 0; iStep < 100; iStep++) {
              vooruit(1);
              slaap(5);
         }
         for (int iTurn = 0; iTurn < 90; iTurn++) {
             draaiRechts(1);
             slaap(2);
         }
      }
  }
  
  /**
   * Teken een driehoek.
   * @param zijde De lengte van een zijde in px.
   */
  public void tekenDriehoek(int zijde) {
      penNeer();
      for (int i = 0; i < 3; i++) {
         for (int iTurn = 0; iTurn < 30; iTurn++) {
             draaiRechts(1);
             slaap(2);
         }
         for (int iStep = 0; iStep < zijde; iStep++) {
              vooruit(1);
              slaap(5);
         }
         for (int iTurn = 0; iTurn < 90; iTurn++) {
             draaiRechts(1);
             slaap(2);
         }
      }
  }
  
  /**
   * Teken een huis bestaande uit een driehoek en een vierkant.
   * @param zijde De lengte van een zijde in px.
   */
  public void tekenHuis(int zijde) {
      tekenDriehoek(zijde);
      for (int iTurn = 0; iTurn < 90; iTurn++) {
          draaiRechts(1);
          slaap(2);
      }
      tekenVierkant(zijde);
  }
  
  /**
   * Teken vier huizen.
   * Natuurwetten worden compleet genegeerd.
   */
  public void vierHuizen() {
      tekenHuis(50);
      tekenHuis(70);
      tekenHuis(90);
      tekenHuis(110);
  }
  
  /**
   * Teken vijf vrijstaande huizen die allemaal een andere kleur hebben.
   */
  public void tekenDorp() {
      setRichting(90);
      String[] colors = {"blauw", "geel", "groen", "rood", "zwart"};
      for (int i = 0; i < 5; i++) {
          setKleur(colors[i]);
          tekenHuis(30+i*20);
          
          penOmhoog();
          for (int iStep = 0; iStep < (30+(i+1)*20); iStep++) {
              vooruit(1);
              slaap(5);
          }
          for (int iTurn = 0; iTurn < 90; iTurn++) {
              draaiLinks(1);
              slaap(2);
          }
          for (int iStep = 0; iStep < 10; iStep++) {
              vooruit(1);
              slaap(5);
          }
      }
  }

  // Hierboven kun je zelf methoden toevoegen
  /**
   * Laat de schildpad een stukje x achteruit lopen
   */
  public void achteruit( double x ) {
    vooruit( -x );
  }

  /** 
   * Doe de pen naar beneden, zodat vanaf nu de schildpad tekent als 
   * vooruit of achteruit gaat.
   */
  public void penNeer() {
    penNeer = true;
  }

  /** 
   * Doe de pen omhoog, zodat vanaf nu de schildpad niet tekent.
   */
  public void penOmhoog() {
    penNeer = false;
  }

  /** 
   * Levert de waarde true als de pen van de schilpad naar beneden is 
   * zodat hij kan tekenen.
   * Levert false als dat niet zo is.
   * @return de waarde van het attribuut penNeer
   */

  public boolean isPenNeer() {
    return penNeer;
  }

  /**
   * De schildpad loopt een aantal pixels vooruit. 
   * @param x het aantal pixels dat de schildpad vooruit loopt; mag ook negatief zijn
   */
  public void vooruit( double x ) {
    Point2D.Double a = null, b = null;
    if( penNeer ) {
      a = new Point2D.Double( xEcht, yEcht );
    }
    xEcht += x * Math.cos ( richting * RAD );
    yEcht -= x * Math.sin ( richting * RAD );
    if( penNeer ) {
      b = new Point2D.Double( xEcht, yEcht );
      Line2D.Double line = new Line2D.Double( a, b );
      tekening.add( new Lijn( line, kleur ) );
    }
    teken();
  }

  /**
   * Wis de tekening van deze schildpad.
   */
  public void wisTekening() {
    tekening.clear();
    teken();
  }


  /**
   * De schildpad draait naar links.
   * @param hoek het aantal graden dat de schildpad naar links draait; mag negatief zijn
   */
  public void draaiLinks( double hoek ) {
    richting += hoek;
    while( richting > 360.0 )
      richting -= 360.0;
    while( richting < 0.0 )
      richting += 360.0;
    teken();
  }

  /**
   * De schildpad draait naar rechts over de opgegeven hoek.
   * @param hoek het aantal graden dat de schildpad naar rechts draait; mag negatief zijn
   */
  public void draaiRechts( double hoek ) {
    draaiLinks( -hoek );
  }


  /**
   * Levert de x-coordinaat van de positie van de schildpad.
   * @return de waarde van de x-coordinaat van deze schildpad
   */
  public int getX() {
    return round( xEcht );
  }
  
  /**
   * Levert de y-coordinaat van de positie van de schildpad.
   * @return de waarde van de y-coordinaat van deze schildpad
   */
  public int getY() {
    return round( yEcht );
  }
  
  /**
   * Levert de richting waarin de schildpad kijkt in graden. 
   * Een paar voorbeelden:
   * 0 graden is naar rechts,
   * 90 graden is naar boven,
   * 180 graden is naar links,
   * 270 graden is naar beneden.
   * @return de waarde van het attribuut richting
   */
   public int getRichting() {
    return round( richting );
  }

  /**
   * Toont deze schildpad in het venster.
   */
  public void toon() {
    verberg = false;
    teken();
  }

  /**
   * Verbergt deze schildpad in het venster.
   */
  public void verberg() {
    verberg = true;
    teken();
  }

  /**
   * Levert true als deze schildpad verborgen is.
   * Anders false
   * @return de waarde van het attribuut verberg
   */
  public boolean isVerborgen() {
    return verberg;
  }

  /**
   * Levert de kleur van de schildpad (en daarmee van de pen).
   * @return de waarde van het attribuut kleur
   */
   public String getKleur() {
    return kleur;
  }
  
  /**
   * Zet deze schildpad terug op zijn uitgangspositie.
   */
  public void reset(){
    xEcht = xDefault;
    yEcht = yDefault;
    richting = richtingDefault;
    verberg = false;
    penNeer = false;
    kleur = "groen";
    teken();    
  }
  
  /**
   * Verandert de kleur van de schildpad. 
   * Toegestane invoer: "blauw", "geel", "groen"
   * "rood" of "zwart". 
   * Bij een niet geldige kleur wordt de schildpad in zwart getekend.
   * @param kleur de kleur die de schildpad en de pen moeten aannemen
   */
  public void setKleur( String kleur ) {
    this.kleur = kleur;
    teken();
  }

  /**
  * Zet de schildpad op positie (x,y).
  * @param x de nieuwe x-coordinaat van de schildpad
  * @param y de nieuwe y-coordinaat van de schildpad
  */
  public void gaNaar( double x, double y ) {
    xEcht = x;
    yEcht = y;
    teken();
  } 

  /**
   * Verander de richting van de schilpad.
   * Een paar voorbeelden:
   * 0 graden is naar rechts,
   * 90 graden is naar boven,
   * 180 graden is naar links,
   * 270 graden is naar beneden.
   * @param richting de nieuwe richting van de schildpad
   */
  public void setRichting( double richting ) {
    this.richting = richting;
    teken();
  }

  /**
    Laat de schildpad slapen
    @param ms het aantal milliseconden dat de schildpad slaapt
  */  
  public void slaap( int ms ) {
    try { Thread.sleep( ms ); }
    catch( InterruptedException e ) { }
  }
 

  // private methoden
  private void teken() {
    if( venster == null )
      venster = new SchildpadVenster( "Venster voor schildpadden" );
    if( !venster.isZichtbaar() )
      venster.maakZichtbaar( true );
    venster.teken( this );
  }
  
  private int round( double x ) {
    return (int) Math.round( x );
  }
  
  private ArrayList< Lijn > getTekening() {
    return tekening;
  }
  
  
  
  // ********** Inwendige klassen *****************************************************************////////////
  
  private class Lijn {
    private Line2D.Double line;
    private String kleur;
    
    public Lijn( Line2D.Double line, String kleur ) {
      this.line = line;
      this.kleur = kleur;
    }
    
    Line2D.Double getLine() {
      return line;
    }
    
    String getKleur() {
      return kleur;
    }
  }
        
  private class SchildpadVenster {
    private final double RAD = Math.PI / 180.0;  
    private JFrame frame;
    private TekenPaneel paneel;
    private Graphics gB;
    private Image buffer;
    
    private HashSet<Schildpad> database;
    private HashMap<String,Color> kleurMap;
   
    public SchildpadVenster( String titel ) {
      frame = new JFrame( titel );
      paneel = new TekenPaneel();
      frame.setContentPane( paneel );
      paneel.setPreferredSize( new Dimension( 1200, 400 ) );
      frame.pack();
      database = new HashSet< Schildpad >();
      kleurMap = new HashMap< String,Color >();
      kleurMap.put( "blauw", Color.blue   );
      kleurMap.put( "geel",  Color.yellow );
      kleurMap.put( "groen", new Color( 58, 165, 5 ) );
      kleurMap.put( "rood",  Color.red    );
      kleurMap.put( "zwart", Color.black  );
      maakZichtbaar( true );
    }  
    
    
    // Overige methoden
    public void maakZichtbaar( boolean zichtbaar ) {
      if( gB == null ) {
        Dimension dim = paneel.getSize();
        buffer = frame.createImage( dim.width, dim.height );
        gB = buffer.getGraphics();
      }
      frame.setVisible( zichtbaar );
    }
    
    public void teken( Schildpad s ) {
      database.add( s );
      herschilder();
    }
      
    public void verwijder( Schildpad s ) {
      database.remove( s );
      herschilder();
    }
  
    public boolean isZichtbaar() {
      return frame.isVisible();
    }
    
    // Private methoden
    private void herschilder() {
      maakBufferSchoon();
      for( Schildpad sp : database ) {
        ArrayList< Lijn > tekening = sp.getTekening();
        for( Lijn lijn : tekening ) {
          Color color = kleurMap.get( lijn.getKleur() );
          gB.setColor( color != null? color : Color.black );
          tekenLijn( lijn.getLine() );
        }
        if( !sp.isVerborgen() )
          tekenSchildpad( sp );
        paneel.repaint();
      }
    }
    
    private void maakBufferSchoon() {
      gB.setColor( Color.white );
      Dimension dim = paneel.getSize();
      gB.fillRect( 0, 0, dim.width, dim.height );
    }
    
    private void tekenLijn( Line2D.Double lijn ) {
      gB.drawLine( round( lijn.getX1() ), round( lijn.getY1() ), round( lijn.getX2() ), round( lijn.getY2() ) );
    }
      
    private void tekenSchildpad( Schildpad sp ) {
      Color color = kleurMap.get( sp.getKleur() );
      gB.setColor( color != null? color : Color.black );
      double x = sp.getX();
      double y = sp.getY();
      double richting = sp.getRichting();
      
      // kop
      tekenCirkel( x, y, 6 );
      
      // lijf
      int dx =  -18;
      x += dx * Math.cos ( richting * RAD );
      y -= dx * Math.sin ( richting * RAD );
      tekenCirkel( x, y, 12 );
      
      // linkervoorpoot
      dx = 10;
      x += dx * Math.cos ( richting * RAD );
      y -= dx * Math.sin ( richting * RAD );
      richting += 90;
      dx = 10;
      x += dx * Math.cos ( richting * RAD );
      y -= dx * Math.sin ( richting * RAD );
      tekenCirkel( x, y, 4 );
  
      // rechtervoorpoot
      dx = -20;
      x += dx * Math.cos ( richting * RAD );
      y -= dx * Math.sin ( richting * RAD );
      tekenCirkel( x, y, 4 );
      
      // rechterachterpoot
      richting += 90;
      dx = 20;
      x += dx * Math.cos ( richting * RAD );
      y -= dx * Math.sin ( richting * RAD );
      richting += 90;
      dx = 2;
      x += dx * Math.cos ( richting * RAD );
      y -= dx * Math.sin ( richting * RAD );
      tekenCirkel( x, y, 4 );
  
      // linkerachterpoot
      dx = -24;
      x += dx * Math.cos ( richting * RAD );
      y -= dx * Math.sin ( richting * RAD );
      tekenCirkel( x, y, 4 );
    }
    
    private void tekenCirkel( double xMpt, double yMpt, int r ) {
      gB.fillOval( round( xMpt - r ), round( yMpt - r ), r+r, r+r );
    }
  
    private int round( double x ) {
      return (int) Math.round( x );
    }
     
    // Inwendige klasse
    private class TekenPaneel extends JPanel {
      public void paint( Graphics g ) {
        g.drawImage( buffer, 0, 0, null );
      }
    }
  }
}
