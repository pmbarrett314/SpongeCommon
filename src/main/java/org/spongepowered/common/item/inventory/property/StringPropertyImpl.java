package org.spongepowered.common.item.inventory.property;

import org.spongepowered.api.data.Property;
import org.spongepowered.api.item.inventory.property.AbstractInventoryProperty;
import org.spongepowered.api.item.inventory.property.StringProperty;
import org.spongepowered.api.util.Coerce;

public final class StringPropertyImpl extends AbstractInventoryProperty<String, String> implements StringProperty {

    /**
     * Create a new {@link StringProperty} for matching the specified value.
     *
     * @param value the value to match
     */
    public StringPropertyImpl(String value) {
        super(value);
    }

    /**
     * Create a new {@link StringProperty} for matching the specified value
     * with the specified operator.
     *
     * @param value the value to match
     * @param operator the operator to use when comparing with other properties
     */
    public StringPropertyImpl(String value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new {@link StringProperty} for matching the specified value
     * with the specified operator.
     *
     * @param value the value to match
     * @param operator the operator to use when comparing with other properties
     */
    public StringPropertyImpl(Object value, Operator operator) {
        super(Coerce.toString(value), operator);
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Property<?, ?> other) {
        if (other == null) {
            return 1;
        }

        return this.getValue().compareTo(Coerce.toString(other.getValue()));
    }

    public static final class BuilderImpl implements StringProperty.Builder {

        private Object value;
        private Operator operator;

        @Override
        public StringProperty.Builder value(final Object value) {
            this.value = value;
            return this;
        }

        @Override
        public StringProperty.Builder operator(final Operator operator) {
            this.operator = operator;
            return this;
        }

        @Override
        public StringProperty.Builder from(final StringProperty value) {
            this.value = value.getValue();
            this.operator = value.getOperator();
            return this;
        }

        @Override
        public StringProperty.Builder reset() {
            this.value = null;
            this.operator = null;
            return this;
        }

        @Override
        public StringProperty build() {
            return new StringPropertyImpl(this.value, this.operator);
        }
    }
}
