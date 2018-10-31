/*
 *
 *  Copyright 2012 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.simianarmy.basic;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.simianarmy.Monkey;
import com.netflix.simianarmy.MonkeyCalendar;
import com.netflix.simianarmy.MonkeyConfiguration;

// CHECKSTYLE IGNORE MagicNumberCheck
/**
 * The Class BasicCalendar.
 */
public class BasicCalendar implements MonkeyCalendar {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicCalendar.class);

    /** The open hour. */
    private final int openHour;

    /** The close hour. */
    private final int closeHour;

    /** The tz. */
    private final TimeZone tz;

    /**
     * Instantiates a new basic calendar.
     *
     * @param cfg
     *            the monkey configuration
     */
    public BasicCalendar(MonkeyConfiguration cfg) {
        this.cfg = cfg;
        openHour = (int) cfg.getNumOrElse("simianarmy.calendar.openHour", 9);
        closeHour = (int) cfg.getNumOrElse("simianarmy.calendar.closeHour", 15);
        tz = TimeZone.getTimeZone(cfg.getStrOrElse("simianarmy.calendar.timezone", "America/Los_Angeles"));
    }

    /**
     * Instantiates a new basic calendar.
     *
     * @param open
     *            the open hour
     * @param close
     *            the close hour
     * @param timezone
     *            the timezone
     */
    public BasicCalendar(int open, int close, TimeZone timezone) {
        openHour = open;
        closeHour = close;
        tz = timezone;
    }

    /**
     * Instantiates a new basic calendar.
     *
     * @param open
     *            the open hour
     * @param close
     *            the close hour
     * @param timezone
     *            the timezone
     */
    public BasicCalendar(MonkeyConfiguration cfg, int open, int close, TimeZone timezone) {
        this.cfg = cfg;
        openHour = open;
        closeHour = close;
        tz = timezone;
    }

    /** {@inheritDoc} */
    @Override
    public int openHour() {
        return openHour;
    }

    /** {@inheritDoc} */
    @Override
    public int closeHour() {
        return closeHour;
    }

}
