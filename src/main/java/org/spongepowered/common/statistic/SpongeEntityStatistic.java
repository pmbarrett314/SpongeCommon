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
package org.spongepowered.common.statistic;

import net.minecraft.stats.StatBase;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.scoreboard.critieria.Criterion;
import org.spongepowered.api.statistic.EntityStatistic;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.common.registry.type.entity.EntityTypeRegistryModule;
import org.spongepowered.common.text.translation.SpongeTranslation;

import java.util.Optional;

import javax.annotation.Nullable;

public final class SpongeEntityStatistic extends StatBase implements EntityStatistic, TypedSpongeStatistic {

    private final String entityId;
    private String spongeId;

    public SpongeEntityStatistic(String statIdIn, ITextComponent statNameIn, String entityId) {
        super(statIdIn, statNameIn);
        this.entityId = entityId;
    }

    @Override
    public EntityType getEntityType() {
        return EntityTypeRegistryModule.getInstance().getById(this.entityId).get();
    }

    @Override
    public Translation getTranslation() {
        return new SpongeTranslation(this.statId);
    }

    @Override
    public Optional<Criterion> getCriterion() {
        return Optional.ofNullable((Criterion) getCriteria());
    }

    @Override
    public String getName() {
        return getStatName().getUnformattedText();
    }

    @Nullable
    @Override
    public String getSpongeId() {
        return this.spongeId;
    }

    @Override
    public void setSpongeId(String id) {
        this.spongeId = id;
    }

    @Override
    public String getMinecraftId() {
        return this.statId;
    }

}
