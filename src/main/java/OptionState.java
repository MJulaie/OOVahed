/**
 * Created by Ali on 5/17/2017 AD.
 */
public class OptionState{
    private int score = -1;
    private OptionLiveState state = OptionLiveState.DARHALEGOZARANDAN;

    public int getScore() {
        return score;
    }

    public OptionLiveState getState() {
        return state;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setState(OptionLiveState state) {
        this.state = state;
    }

    public boolean isPassed(){
        if (score >= 10){
            //magic number!!!!!!!!!
            return true;
        } else {
            return false;
        }
    }
}
