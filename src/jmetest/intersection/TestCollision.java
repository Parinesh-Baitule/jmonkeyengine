/*
 * Copyright (c) 2003-2004, jMonkeyEngine - Mojo Monkey Coding
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
package jmetest.intersection;

import com.jme.app.SimpleGame;
import com.jme.bounding.BoundingBox;
import com.jme.image.Texture;
import com.jme.intersection.CollisionDetection;
import com.jme.intersection.CollisionResults;
import com.jme.math.Quaternion;
import com.jme.math.Vector3f;
import com.jme.scene.Node;
import com.jme.scene.Text;
import com.jme.scene.TriMesh;
import com.jme.scene.shape.Box;
import com.jme.scene.state.TextureState;
import com.jme.util.TextureManager;

/**
 * <code>TestCollision</code>
 * @author Mark Powell
 * @version $Id: TestCollision.java,v 1.15 2004-04-23 02:57:23 renanse Exp $
 */
public class TestCollision extends SimpleGame {

  private TriMesh t;
  private TriMesh t2;
  private Text text;
  private Node scene;
  private Quaternion rotQuat = new Quaternion();
  private float angle = 0;
  private Vector3f axis = new Vector3f(1, 0, 0);

  private float tInc = -40.0f;
  private float t2Inc = -10.0f;

  /**
   * Entry point for the test,
   * @param args
   */
  public static void main(String[] args) {
    TestCollision app = new TestCollision();
    app.setDialogBehaviour(ALWAYS_SHOW_PROPS_DIALOG);
    app.start();
  }

  protected void simpleUpdate() {
    if (timer.getTimePerFrame() < 1) {
      angle = angle + (timer.getTimePerFrame() * 1);
      if (angle > 360) {
        angle = 0;
      }
    }

    rotQuat.fromAngleAxis(angle, axis);

    t.setLocalRotation(rotQuat);

    t.getLocalTranslation().y += tInc * timer.getTimePerFrame();
    t2.getLocalTranslation().x += t2Inc * timer.getTimePerFrame();

    if (t.getLocalTranslation().y > 40) {
      t.getLocalTranslation().y = 40;
      tInc *= -1;
    } else if (t.getLocalTranslation().y < -40) {
      t.getLocalTranslation().y = -40;
      tInc *= -1;
    }

    if (t2.getLocalTranslation().x > 40) {
      t2.getLocalTranslation().x = 40;
      t2Inc *= -1;
    } else if (t2.getLocalTranslation().x < -40) {
      t2.getLocalTranslation().x = -40;
      t2Inc *= -1;
    }

    CollisionResults results = new CollisionResults();

    CollisionDetection.hasCollision(t, scene, results);

    if (results.getNumber() > 0) {
      text.print("Collision: YES");
    } else {
      text.print("Collision: NO");
    }
  }

  /**
   * builds the trimesh.
   * @see com.jme.app.SimpleGame#initGame()
   */
  protected void simpleInitGame() {
    display.setTitle("Collision Detection");
    cam.setLocation(new Vector3f(0.0f, 0.0f, 75.0f));
    cam.update();

    text = new Text("Text Label", "Collision: No");
    text.setLocalTranslation(new Vector3f(1, 60, 0));
    fpsNode.attachChild(text);

    scene = new Node("3D Scene Root");

    Vector3f max = new Vector3f(5, 5, 5);
    Vector3f min = new Vector3f( -5, -5, -5);

    t = new Box("Box 1", min, max);
    t.setModelBound(new BoundingBox());
    t.updateModelBound();
    t.setLocalTranslation(new Vector3f(0, 30, 0));

    t2 = new Box("Box 2", min, max);
    t2.setModelBound(new BoundingBox());
    t2.updateModelBound();
    t2.setLocalTranslation(new Vector3f(30, 0, 0));

    scene.attachChild(t);
    scene.attachChild(t2);

    TextureState ts = display.getRenderer().getTextureState();
    ts.setEnabled(true);
    ts.setTexture(
        TextureManager.loadTexture(
        TestCollision.class.getClassLoader().getResource(
        "jmetest/data/images/Monkey.jpg"),
        Texture.MM_LINEAR,
        Texture.FM_LINEAR,
        true));

    scene.setRenderState(ts);
    rootNode.attachChild(scene);
  }
}
