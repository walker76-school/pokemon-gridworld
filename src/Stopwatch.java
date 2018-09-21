import java.util.concurrent.TimeUnit;

/**
 * Class that interfaces with the clock to get the current time
 * @author Andrew
 *
 */
public class Stopwatch { 

    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public Stopwatch() {
        start = System.currentTimeMillis();
    } 

    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public long elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start);
    }
    
    /**
     * formats the time to a standard hh:mm:ss
     * @return the time in the format hh:mm:ss
     */
    public String format()
    {
    	return String.format("%02d:%02d:%02d", 
    		    TimeUnit.MILLISECONDS.toHours(elapsedTime()),
    		    TimeUnit.MILLISECONDS.toMinutes(elapsedTime()) - 
    		    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(elapsedTime())),
    		    TimeUnit.MILLISECONDS.toSeconds(elapsedTime()) - 
    		    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsedTime())));
    }
} 