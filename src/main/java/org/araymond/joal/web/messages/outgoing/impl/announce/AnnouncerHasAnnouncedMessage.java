package org.araymond.joal.web.messages.outgoing.impl.announce;

import com.google.common.base.Preconditions;
import org.araymond.joal.core.ttorent.client.MockedTorrent;
import org.araymond.joal.core.ttorent.client.bandwidth.TorrentWithStats;
import org.araymond.joal.web.messages.outgoing.OutgoingMessage;
import org.araymond.joal.web.messages.outgoing.OutgoingMessageTypes;

/**
 * Created by raymo on 25/06/2017.
 */
public class AnnouncerHasAnnouncedMessage extends AnnounceMessage {

    private final int interval;
    private final int seeders;
    private final int leechers;

    public AnnouncerHasAnnouncedMessage(final TorrentWithStats torrent, final int interval, final int seeders, final int leechers) {
        super(OutgoingMessageTypes.ANNOUNCER_HAS_ANNOUNCED, torrent);
        this.interval = interval;
        this.seeders = seeders;
        this.leechers = leechers;
    }

    public int getInterval() {
        return interval;
    }

    public int getSeeders() {
        return seeders;
    }

    public int getLeechers() {
        return leechers;
    }
}
