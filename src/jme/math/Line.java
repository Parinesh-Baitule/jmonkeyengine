/*
 * Copyright (c) 2003, jMonkeyEngine - Mojo Monkey Coding
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this 
 * list of conditions and the following disclaimer. 
 * 
 * Redistributions in binary form must reproduce the above copyright notice, 
 * this list of conditions and the following disclaimer in the documentation 
 * and/or other materials provided with the distribution. 
 * 
 * Neither the name of the Mojo Monkey Coding, jME, jMonkey Engine, nor the 
 * names of its contributors may be used to endorse or promote products derived 
 * from this software without specific prior written permission. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */
package jme.math;

/**
 * <code>Line</code> defines a line represented as 
 * L(t) = origin + t * direction for any real-valued t, and
 * direction is not necessarily unit length. This can further be thought of as 
 * a ray, infinite line or a line segment.
 * 
 * @author Mark Powell
 * @version $Id: Line.java,v 1.2 2003-08-22 02:26:48 mojomonkey Exp $
 */
public class Line {
    private Vector origin;
    private Vector direction;

    /**
     * Default constructor instantiates a new <code>Line</code> that is defined
     * by an origin and a direction. 
     *
     */
    public Line() {
        origin = new Vector();
        direction = new Vector();
    }

    /**
     * Constructor instantiates a new <code>Line</code> that is supplied an
     * origin and direction.
     * @param origin the origin of the line.
     * @param direction the direction of the line.
     */
    public Line(Vector origin, Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }

    /**
     * <code>getDirection</code> returns the direction of the line.
     * @return the direction of the line.
     */
    public Vector getDirection() {
        return direction;
    }

    /**
     * <code>setDirection</code> sets the direction of the line.
     * @param direction the new direction of the line.
     */
    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    /**
     * <code>getOrigin</code> retrieves the direction of the line.
     * @return the direction of the line.
     */
    public Vector getOrigin() {
        return origin;
    }

    /**
     * <code>setOrigin</code> sets the new origin of the line.
     * @param origin the new origin of the line.
     */
    public void setOrigin(Vector origin) {
        this.origin = origin;
    }
}
