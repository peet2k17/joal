package org.araymond.joal.core.client.emulated.generator.key;

import com.turn.ttorrent.common.protocol.TrackerMessage.AnnounceRequestMessage.RequestEvent;
import org.araymond.joal.core.client.emulated.generator.key.algorithm.KeyAlgorithm;
import org.araymond.joal.core.client.emulated.utils.Casing;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by raymo on 16/07/2017.
 */
public class AlwaysRefreshKeyGeneratorTest {

    @Test
    public void shouldRefreshKeyEveryTime() {
        final KeyAlgorithm algo = Mockito.mock(KeyAlgorithm.class);
        Mockito.when(algo.generate()).thenReturn("do-not-care");
        final KeyGenerator generator = new AlwaysRefreshKeyGenerator(algo, Casing.NONE);

        for (int i = 0; i < 50; ++i) {
            generator.getKey(null, RequestEvent.STARTED);
        }

        Mockito.verify(algo, Mockito.times(50)).generate();
    }

}
