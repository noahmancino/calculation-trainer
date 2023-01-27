package model.domain;
import org.springframework.beans.factory.parsing.Problem;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Game implements Serializable {
    private Date FinishTime;
    private List<Integer> score;
    private String problemType;
    private int[] valueRange;
    long millisTocCompletion;


}
