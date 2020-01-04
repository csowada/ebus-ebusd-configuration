package de.csdev.ebus.ebusd_configuration.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.csdev.ebus.cfg.EBusConfigurationReaderException;
import de.csdev.ebus.command.EBusCommandRegistry;
import de.csdev.ebus.command.EBusCommandUtils;
import de.csdev.ebus.command.IEBusCommand;
import de.csdev.ebus.command.IEBusCommandMethod;
import de.csdev.ebus.command.datatypes.EBusTypeException;
import de.csdev.ebus.ebusd_configuration.EBusConfigurationReaderExt;
import de.csdev.ebus.utils.EBusUtils;

/**
 * @author Christian Sowada - Initial contribution
 *
 */
public class EBusVaillantEbusdTest {

    private final Logger logger = LoggerFactory.getLogger(EBusVaillantEbusdTest.class);

    private EBusCommandRegistry commandRegistry;

    @Before
    public void before() throws IOException, EBusConfigurationReaderException {

        commandRegistry = new EBusCommandRegistry(EBusConfigurationReaderExt.class, true);
    }

    @Test
    public void test39200_DisplayedRoomTemp() {

        try {
            IEBusCommand command = commandRegistry.getCommandById("39200", "DisplayedRoomTemp");

            assertNotNull(command);

            IEBusCommandMethod commandMethod = command.getCommandMethod(IEBusCommandMethod.Method.GET);

            assertNotNull(commandMethod);

            Map<String, Object> values = new HashMap<String, Object>();

            ByteBuffer buffer = EBusCommandUtils.buildMasterTelegram(commandMethod, (byte) 0x00, (byte) 0x08, values);

            assertNotNull(buffer);

            logger.info("Generated Master Telegram: {}", EBusUtils.toHexDumpString(buffer));
            logger.info("Command Method Get: {}", commandMethod);

        } catch (EBusTypeException e) {
            fail();
        }

    }

    @Test
    public void test39200_RoomTemp() {

        try {
            IEBusCommand command = commandRegistry.getCommandById("39200", "RoomTemp");

            assertNotNull(command);

            IEBusCommandMethod commandMethod = command.getCommandMethod(IEBusCommandMethod.Method.GET);

            assertNotNull(commandMethod);

            Map<String, Object> values = new HashMap<String, Object>();

            ByteBuffer buffer = EBusCommandUtils.buildMasterTelegram(commandMethod, (byte) 0x00, (byte) 0x08, values);

            assertNotNull(buffer);

            logger.info("Generated Master Telegram: {}", EBusUtils.toHexDumpString(buffer));
            logger.info("Command Method Get: {}", commandMethod);

        } catch (EBusTypeException e) {
            fail();
        }
    }

}
