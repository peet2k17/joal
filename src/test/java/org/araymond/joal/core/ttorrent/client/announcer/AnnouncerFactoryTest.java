package org.araymond.joal.core.ttorrent.client.announcer;

import org.araymond.joal.core.torrent.torrent.MockedTorrent;
import org.araymond.joal.core.ttorrent.client.announcer.request.AnnounceDataAccessor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class AnnouncerFactoryTest {

    @Test
    public void shouldCreate() {
        final AnnounceDataAccessor announceDataAccessor = mock(AnnounceDataAccessor.class);
        final AnnouncerFactory announcerFactory = new AnnouncerFactory(announceDataAccessor);

        final MockedTorrent torrent = mock(MockedTorrent.class);
        final Announcer announcer = announcerFactory.create(torrent);

        assertThat(announcer.getTorrent()).isEqualTo(torrent);
    }

}
