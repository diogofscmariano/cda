package pt.webdetails.cda;

import javax.swing.table.TableModel;
import java.util.Arrays;
import java.util.HashSet;

public class CdaTestHelper {

  public static <T> boolean columnContains( TableModel table, int colIdx, T... values ) {
    HashSet<T> set = new HashSet<T>();
    set.addAll( Arrays.asList( values ) );
    for ( int i = 0; i < table.getRowCount(); i++ ) {
      set.remove( table.getValueAt( i, colIdx ) );
      if ( set.isEmpty() ) {
        return true;
      }
    }
    return false;
  }

  public static <T> boolean columnContains( TableModel table, int colIdx, T value ) {
    for ( int i = 0; i < table.getRowCount(); i++ ) {
      if ( value.equals( table.getValueAt( i, colIdx ) ) ) {
        return true;
      }
    }
    return false;
  }

  public static boolean numericEquals( double actual, double expected, double delta ) {
    return Math.abs( actual - expected ) < delta;
  }

  public static boolean numericEquals( String actual, String expected, double delta ) {
    return numericEquals( Double.parseDouble( actual ), Double.parseDouble( expected ), delta );
  }
}
