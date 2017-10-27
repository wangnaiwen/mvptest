package com.wnw.wnw.mvptest.download;

/**
 * The enum Down state.
 *
 * @author wnw
 * @date 2017 /10/26 0026 15:28
 */
public enum DownState {
    /**
     * Start down state.
     */
    START(0),
    /**
     * Down down state.
     */
    DOWN(1),
    /**
     * Pause down state.
     */
    PAUSE(2),
    /**
     * Stop down state.
     */
    STOP(3),
    /**
     * Error down state.
     */
    ERROR(4),
    /**
     * Finish down state.
     */
    FINISH(5);
    private int state;

    /**
     * Gets state.
     *
     * @return the state
     */
    public int getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(int state) {
        this.state = state;
    }

    DownState(int state) {
        this.state = state;
    }

}
