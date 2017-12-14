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
package org.spongepowered.common.item.inventory.property;

import org.spongepowered.api.data.Property;
import org.spongepowered.api.item.inventory.property.SlotSide;
import org.spongepowered.api.util.Coerce;
import org.spongepowered.api.util.Direction;

public final class SlotSideImpl extends AbstractInventoryProperty<String, Direction> implements SlotSide {

    /**
     * Create a new SlotSide property for matching the specified value.
     *
     * @param value the value to match
     */
    public SlotSideImpl(Direction value) {
        super(value);
    }

    /**
     * Create a new SlotSide property for matching the specified value with the
     * specified operator.
     *
     * @param value the value to match
     * @param operator the operator to use when comparing with other properties
     */
    public SlotSideImpl(Direction value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new SlotSide property for matching the specified value with the
     * specified operator.
     *
     * @param value the value to match
     * @param operator the operator to use when comparing with other properties
     */
    public SlotSideImpl(Object value, Operator operator) {
        super(Coerce.<Direction>toEnum(value, Direction.class, Direction.NONE), operator);
    }

    @Override
    public int compareTo(Property<?, ?> other) {
        if (other == null) {
            return 1;
        }

        return this.getValue().compareTo(Coerce.toEnum(other.getValue(), Direction.class, Direction.NONE));
    }

    public static final class BuilderImpl implements SlotSide.Builder {

        private Object value;
        private Operator operator;

        @Override
        public SlotSide.Builder value(final Object value) {
            this.value = value;
            return this;
        }

        @Override
        public SlotSide.Builder operator(final Operator operator) {
            this.operator = operator;
            return this;
        }

        @Override
        public SlotSide.Builder from(final SlotSide value) {
            this.value = value.getValue();
            this.operator = value.getOperator();
            return this;
        }

        @Override
        public SlotSide.Builder reset() {
            this.value = null;
            this.operator = null;
            return this;
        }

        @Override
        public SlotSide build() {
            return new SlotSideImpl(this.value, this.operator);
        }
    }
}
