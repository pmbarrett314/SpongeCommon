/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.common.event;

import org.spongepowered.api.event.CauseStackManager;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.meta.TypeQualifierDefault;


/**
 * Annotates a specific method that has "declared" itself to be contributing
 * to the {@link CauseStackManager} without "neutrality", expecting for
 * either a {@link CauseStackManager.StackFrame}, or appropriately calculated
 * {@link CauseStackManager#popCauses(int)}, to be manually called to remove
 * the pushed objects to causes, and most importantly, added contexts.
 *
 * <p>The importance of this being used is to blatantly mark methods that are
 * <b>not</b> stack neutral, and to be able to warn their use in implementation
 * calls wherever they may be.</p>
 *
 * <p>Likewise, if at all possible to utilize this annotation in a way where
 * the MinecraftDev plugin can visualize that a method is not stack neutral,
 * and being called in such a way it is not neutral, we can mark it as a
 * warning.</p>
 */
@Documented
@TypeQualifierDefault(ElementType.METHOD)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface NotStackNeutral {

}
