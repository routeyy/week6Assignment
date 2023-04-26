package week6;

import java.util.ArrayList;

@SuppressWarnings("serial")
public abstract class AbstractCardList extends ArrayList<WarCard> {
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    String lf = System.lineSeparator();
    String space = "   ";
    
    result.append(getClass().getSimpleName()).append(": ").append(lf);
    
    for (WarCard card : this) {   //"this" refers to the List<WarCard>
      result.append(space).append(card).append(lf);
    }
    
    return result.toString();
  }
}
