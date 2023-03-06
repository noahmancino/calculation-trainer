package com.mental_math.model.domain;
import com.mental_math.util.ApplicationConstants;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

// TODO: further validation
@Data
@AllArgsConstructor
public class Game implements Serializable {
    @NotNull(message = "Missing required field finshTime.")
    private Date finishTime;
    @NotNull(message = "Missing required field score.")
    private List<Integer> score;
    @NotNull(message = "Missing required field gameType")
    private String gameType;
    @NotNull(message = "Missing required field difficulty")
    private String difficulty;
    @NotNull(message = "Missing required field difficulty")
    private long millisTocCompletion;


}
