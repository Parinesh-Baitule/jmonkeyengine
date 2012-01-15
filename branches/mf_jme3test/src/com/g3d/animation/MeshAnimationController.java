/*
 * Copyright (c) 2003-2009 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


package com.g3d.animation;

import com.g3d.export.Savable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Collection;

public class MeshAnimationController {
//
//    /**
//     * If true, hardware skinning will not be used even if supported.
//     */
//    private static final boolean forceSWskinning = true;
//
//    /**
//     * List of targets which this controller effects.
//     */
//    private OgreMesh[] targets;
//
//    /**
//     * Skeleton object must contain corresponding data for the targets' weight buffers.
//     */
//    private Skeleton skeleton;
//
//    /**
//     * List of animations, bone or vertex based.
//     */
//    private Map<String, Animation> animationMap;
//
//    /**
//     * The currently playing animation.
//     */
//    private Animation animation;
//    private float time = 0f;
//
//    /**
//     * True if the mesh data should be reset to bind pose every frame.
//     * This only refers to mesh data, the skeleton must always be reset to bind pose each frame.
//     */
//    private boolean resetToBindEveryFrame = false;
//
//    /**
//     * Frameskip LOD option
//     */
//    private int framesToSkip = 0;
//    private int curFrame = 0;
//
//
//    /**
//     * Animation to blend from, e.g the animation
//     * that was set before setAnimation() was called.
//     */
//    private transient Animation blendFrom = null;
//
//    /**
//     * How much to blend the new animation,
//     * a value of 0 indicates apply only the previous animation
//     * while a value of 1 means apply only the current animation.
//     */
//    private transient float blendScale = 0f;
//
//    /**
//     * Multiply this by TPF to get an addition value for blendScale,
//     * makes sure blendScale only becomes 1 when the blend time has been
//     * reached.
//     */
//    private transient float blendMultiply = 0f;
//
//    /**
//     * Same as the <code>time</code> variable but for
//     * the blendFrom animation.
//     */
//    private transient float blendFromTime = 0f;
//
//
//    public MeshAnimationController(OgreMesh[] meshes,
//                                   Skeleton skeleton,
//                                   Map<String, Animation> anims){
//
//        this.setRepeatType(RT_WRAP);
//        this.skeleton = skeleton;
//        this.animationMap = anims;
//        this.targets = meshes;
//
//        // find out which meshes need to have bind pose data saved
//        for (int i = 0; i < targets.length; i++){
//            // does this mesh has any pose/morph animation tracks?
//            for (Animation anim : animationMap.values()){
//                MeshAnimation manim = anim.getMeshAnimation();
//                BoneAnimation banim = anim.getBoneAnimation();
//
//                if (manim != null){
//                    for (Track t : manim.getTracks()){
//                        if (t.getTargetMeshIndex() == i){
//                            targets[i].clearBindPose();
//                            targets[i].saveCurrentToBindPose();
//                            break;
//                        }
//                    }
//                }
//
//                if (banim != null && !isHardwareSkinning()){
//                    targets[i].clearBindPose();
//                    targets[i].saveCurrentToBindPose();
//                    break;
//                }
//            }
//
//            if (targets[i].getWeightBuffer() != null)
//                targets[i].getWeightBuffer().initializeWeights();
//        }
//
//        if (isHardwareSkinning()){
//            assignShaderLogic();
//        }
//
//        reset();
//    }
//
//    /**
//     * Copy constructor. The mesh data has to be unique, and copied through OgreMesh.cloneFromMesh.
//     * The rest is handled automatically by this call.
//     */
//    public MeshAnimationController(OgreMesh[] meshes, MeshAnimationController sourceControl){
//        this.setRepeatType(RT_WRAP);
//        this.skeleton = new Skeleton(sourceControl.skeleton);
//        this.animationMap = sourceControl.animationMap;
//        this.targets = meshes;
//
//        if (isHardwareSkinning()){
//            assignShaderLogic();
//        }
//
//        reset();
//    }
//
//    /**
//     * Used only for Saving/Loading models (all parameters of the non-default
//     * constructor are restored from the saved model, but the object must be
//     * constructed beforehand)
//     */
//    public MeshAnimationController() {
//    }
//
//    /**
//     * Returns a bone with the specified name.
//     * Use this method to gain access to the bone,
//     * to manually control it's transforms.
//     */
//    public Bone getBone(String name){
//        return skeleton.getBone(name);
//    }
//
//    /**
//     * Sets the currently active animation.
//     * Use the animation name "<bind>" to set the model into bind pose.
//     *
//     * @returns true if the animation has been successfuly set. False if no such animation exists.
//     */
//    public boolean setAnimation(String name, float blendTime){
//        if (name.equals("<bind>")){
//            reset();
//            return true;
//        }
//
//        if (blendTime > 0f){
//            blendFrom = animation;
//            blendMultiply = 1f / blendTime;
//            blendScale = 0f;
//        }
//
//        animation = animationMap.get(name);
//
//        if (animation == null)
//            return false;
//
//        resetToBind();
//        resetToBindEveryFrame = animation.hasMeshAnimation() || !isHardwareSkinning();
//
//        time = 0;
//
//        return true;
//    }
//
//    /**
//     * Sets the currently active animation.
//     * Use the animation name "<bind>" to set the model into bind pose.
//     *
//     * @returns true if the animation has been successfuly set. False if no such animation exists.
//     */
//    public boolean setAnimation(String name){
//        return setAnimation(name, 0f);
//    }
//
//    /**
//     * Returns the length of the animation in seconds. Returns -1 if the animation is not defined.
//     */
//    public float getAnimationLength(String name){
//        Animation anim = animationMap.get(name);
//
//        if (anim == null)
//            return -1;
//
//        return anim.getLength();
//    }
//
//    /**
//     * @return The name of the currently active animation
//     */
//    public String getActiveAnimation(){
//        if (animation == null)
//            return "<bind>";
//
//        return animation.getName();
//    }
//
//    /**
//     * @return Collection of list of all animations that are defined
//     */
//    public Collection<String> getAnimationNames(){
//        return animationMap.keySet();
//    }
//
//    /**
//     * Enables frameskip LOD.
//     * This technique is mostly only effective when software skinning is used.
//     *
//     * @param framesToSkip One frame will be played out of the framesToSkip number.
//     */
//    public void setFrameSkip(int framesToSkip){
//        if (this.framesToSkip != framesToSkip)
//            this.curFrame = 0;
//
//        this.framesToSkip = framesToSkip;
//    }
//
//    public float getCurTime() {
//        return time;
//    }
//
//    /**
//     * Sets the time of the animation.
//     * If it's greater than getAnimationLength(getActiveAnimation()),
//     * the time will be appropriately clamped/wraped depending on the repeatMode.
//     */
//    public void setCurTime(float time){
//        this.time = time;
//    }
//
//    Skeleton getSkeleton(){
//        return skeleton;
//    }
//
//    OgreMesh[] getMeshList(){
//        return targets;
//    }
//
//    void reset(){
//        resetToBind();
//        if (skeleton != null){
//            skeleton.resetAndUpdate();
//        }
//        resetToBindEveryFrame = false;
//        animation = null;
//        time = 0;
//    }
//
//    void resetToBind(){
//        for (int i = 0; i < targets.length; i++){
//            if (targets[i].hasBindPose()){
//                targets[i].restoreBindPose();
//            }
//        }
//    }
//
//    private void assignShaderLogic(){
//        SkinningShaderLogic logic = new SkinningShaderLogic();
//        for (OgreMesh target : targets){
//            GLSLShaderObjectsState glsl =
//                    (GLSLShaderObjectsState) target.getRenderState(StateType.GLSLShaderObjects);
//
//            if (glsl == null){
//                glsl = BoneAnimationLoader.createSkinningShader(skeleton.getBoneCount(),
//                                                                target.getWeightBuffer().maxWeightsPerVert);
//                target.setRenderState(glsl);
//            }
//            glsl.setShaderDataLogic(logic);
//        }
//    }
//
//    /**
//     * @return True if hardware skinning will be used.
//     */
//    public boolean isHardwareSkinning(){
//        return !forceSWskinning && GLSLShaderObjectsState.isSupported();
//    }
//
//    private void softwareSkinUpdate(OgreMesh mesh, Matrix4f[] offsetMatrices){
//        Vector3f vt = new Vector3f();
//        Vector3f nm = new Vector3f();
//        Vector3f resultVert = new Vector3f();
//        Vector3f resultNorm = new Vector3f();
//
//        // NOTE: This code assumes the vertex buffer is in bind pose
//        // resetToBind() has been called this frame
//        FloatBuffer vb = mesh.getVertexBuffer();
//        vb.rewind();
//
//        FloatBuffer nb = mesh.getNormalBuffer();
//        nb.rewind();
//
//        // get boneIndexes and weights for mesh
//        ByteBuffer ib = mesh.getWeightBuffer().indexes;
//        FloatBuffer wb = mesh.getWeightBuffer().weights;
//        int maxWeightsPerVert = mesh.getWeightBuffer().maxWeightsPerVert;
//        int fourMinusMaxWeights = 4 - maxWeightsPerVert;
//        ib.rewind();
//        wb.rewind();
//
//        // iterate vertices and apply skinning transform for each effecting bone
//        for (int vert = 0; vert < mesh.getVertexCount(); vert++){
//            vt.x = vb.get();
//            vt.y = vb.get();
//            vt.z = vb.get();
//            nm.x = nb.get();
//            nm.y = nb.get();
//            nm.z = nb.get();
//            resultVert.x = resultVert.y = resultVert.z = 0;
//            resultNorm.x = resultNorm.y = resultNorm.z = 0;
//
//            for (int w = 0; w < maxWeightsPerVert; w++){
//                float weight = wb.get();
//                Matrix4f mat = offsetMatrices[ib.get()];
//
//                resultVert.x += (mat.m00 * vt.x + mat.m01 * vt.y + mat.m02 * vt.z + mat.m03) * weight;
//                resultVert.y += (mat.m10 * vt.x + mat.m11 * vt.y + mat.m12 * vt.z + mat.m13) * weight;
//                resultVert.z += (mat.m20 * vt.x + mat.m21 * vt.y + mat.m22 * vt.z + mat.m23) * weight;
//
//                resultNorm.x += (nm.x * mat.m00 + nm.y * mat.m01 + nm.z * mat.m02) * weight;
//                resultNorm.y += (nm.x * mat.m10 + nm.y * mat.m11 + nm.z * mat.m12) * weight;
//                resultNorm.z += (nm.x * mat.m20 + nm.y * mat.m21 + nm.z * mat.m22) * weight;
//            }
//
//            ib.position(ib.position()+fourMinusMaxWeights);
//            wb.position(wb.position()+fourMinusMaxWeights);
//
//            // overwrite vertex with transformed pos
//            vb.position(vb.position()-3);
//            vb.put(resultVert.x).put(resultVert.y).put(resultVert.z);
//
//            nb.position(nb.position()-3);
//            nb.put(resultNorm.x).put(resultNorm.y).put(resultNorm.z);
//        }
//
//        vb.flip();
//        nb.flip();
//
//        mesh.setHasDirtyVertices(true);
//        mesh.updateModelBound();
//    }
//
//    public float clampWrapTime(float t, float max, int repeatMode){
//        if (t < 0f){
//            switch (repeatMode){
//                case RT_CLAMP:
//                    return 0;
//                case RT_CYCLE:
//                    return 0;
//                case RT_WRAP:
//                    return max - t;
//            }
//        }else if (t > max){
//            switch (repeatMode){
//                case RT_CLAMP:
//                    return max;
//                case RT_CYCLE:
//                    return max;
//                case RT_WRAP:
//                    return t - max;
//            }
//        }
//
//        return t;
//    }
//
//    @Override
//    public void update(float tpf) {
//        if (!isActive() || animation == null)
//            return;
//
//        // do clamping/wrapping of time
//        time = clampWrapTime(time, animation.getLength(), getRepeatType());
//        if (blendFrom != null){
//            blendFromTime = clampWrapTime(blendFromTime, blendFrom.getLength(), getRepeatType());
//        }
//
//        if (framesToSkip > 0){
//            // check frame skipping
//            curFrame++;
//
//            if (curFrame != framesToSkip){
//                time += tpf * getSpeed();
//                if (blendFrom != null)
//                    blendFromTime += tpf * getSpeed();
//
//                return;
//            }else{
//                curFrame = 0;
//            }
//        }
//
//        if (resetToBindEveryFrame)
//            resetToBind(); // reset morph meshes to bind pose
//
//        if (animation.hasBoneAnimation()){
//            skeleton.reset(); // reset skeleton to bind pose
//        }
//
//        if (blendFrom == null){
//            animation.setTime(time, targets, skeleton, 1f);
//        }else{
//            blendFrom.setTime(blendFromTime, targets, skeleton, 1f - blendScale);
//            animation.setTime(time, targets, skeleton, blendScale);
//
//            // here update the blending scale
//            blendScale += tpf * blendMultiply;
//            if (blendScale > 1f){
//                blendFrom = null;
//                blendScale = 0f;
//                blendMultiply = 0f;
//            }
//        }
//
//        if (animation.hasBoneAnimation()){
//            skeleton.updateWorldVectors();
//
//            if (!isHardwareSkinning()){
//                // here update the targets verticles if no hardware skinning supported
//
//                Matrix4f[] offsetMatrices = skeleton.computeSkinningMatrices();
//
//                // if hardware skinning is supported, the matrices and weight buffer
//                // will be sent by the SkinningShaderLogic object assigned to the shader
//                for (int i = 0; i < targets.length; i++){
//                    softwareSkinUpdate(targets[i], offsetMatrices);
//                }
//            }
//        }
//
//        time += tpf * getSpeed();
//        if (blendFrom != null)
//            blendFromTime += tpf * getSpeed();
//    }
//
//    @Override
//    public void read(JMEImporter i) throws IOException{
//        super.read(i);
//
//        InputCapsule in = i.getCapsule(this);
//        Savable[] sav = in.readSavableArray("targets", null);
//        if (sav != null){
//            targets = new OgreMesh[sav.length];
//            System.arraycopy(sav, 0, targets, 0, sav.length);
//        }
//        skeleton = (Skeleton) in.readSavable("skeleton", null);
//        animationMap = (Map<String, Animation>) in.readStringSavableMap("animations", null);
//    }
//
//    @Override
//    public void write(JMEExporter e) throws IOException{
//        super.write(e);
//
//        OutputCapsule out = e.getCapsule(this);
//        out.write(targets, "targets", null);
//        out.write(skeleton, "skeleton", null);
//        out.writeStringSavableMap(animationMap, "animations", null);
//    }

}