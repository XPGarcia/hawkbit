/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.ddi.json.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The action that has to be stopped by the target.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DdiCancelActionToStop {

    @NotNull
    private final String stopId;

    /**
     * Parameterized constructor.
     *
     * @param stopId
     *            ID of the action to be stopped
     */
    @JsonCreator
    public DdiCancelActionToStop(@JsonProperty("stopId") final String stopId) {
        this.stopId = stopId;
    }

    public String getStopId() {
        return stopId;
    }

    @Override
    public String toString() {
        return "CancelAction [stopId=" + stopId + "]";
    }

}
