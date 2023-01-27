package model.domain;
import org.springframework.beans.factory.parsing.Problem;

import java.util.Date;
import java.util.List;

public class Game {
    private Date FinishTime;
    private List<Integer> score;
    private String problemType;
    private int[] valueRange;
    long millisTocCompletion;


}
