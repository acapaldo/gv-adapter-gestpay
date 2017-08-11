/*******************************************************************************
 * Copyright (c) 2009, 2017 GreenVulcano ESB Open Source Project.
 * All rights reserved.
 *
 * This file is part of GreenVulcano ESB.
 *
 * GreenVulcano ESB is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GreenVulcano ESB is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GreenVulcano ESB. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package it.greenvulcano.gvesb.virtual.gv_gestpay;

import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;

import it.greenvulcano.configuration.XMLConfig;
import it.greenvulcano.gestpay.wscryptdecrypt.model.WSCryptDecrypt;
import it.greenvulcano.gestpay.wss2s.model.WSs2S;
import it.greenvulcano.gvesb.buffer.GVBuffer;
import it.greenvulcano.gvesb.virtual.CallException;
import it.greenvulcano.gvesb.virtual.CallOperation;
import it.greenvulcano.gvesb.virtual.ConnectionException;
import it.greenvulcano.gvesb.virtual.InitializationException;
import it.greenvulcano.gvesb.virtual.InvalidDataException;
import it.greenvulcano.gvesb.virtual.OperationKey;
import it.greenvulcano.gvesb.virtual.gv_gestpay.operation.EncryptOperation;


/**
 * 
 * @version 4.0 august/2017
 * @author GreenVulcano Developer Team
 */
public class GestPayCallOperation implements CallOperation {
    
    private static final Logger logger 	= LoggerFactory.getLogger(GestPayCallOperation.class);    
    private OperationKey key 			= null;
    
    protected String name;
    protected String operation;
    protected String response;
    
    private String cryptDecryptType 	= "GESTPAYCryptDecryptAdapter";
    private String s2sType 				= "GESTPAYs2sAdapter";
    
    private Map<String, WSCryptDecrypt> cryptDecryptChannels 	= Activator.cryptDecryptChannels;
    private Map<String, WSs2S> s2sChannels 						= Activator.s2sChannels;
    
    private WSCryptDecrypt wsCryptDecryp 	= null;
    private WSs2S wss2s 					= null;
    
    @Override
    public void init(Node node) throws InitializationException  {
        logger.debug("Init start");
        try {            
            name =  XMLConfig.get(node, "@name");
            operation = XMLConfig.get(node, "@action_operation");
            
            String sysName = XMLConfig.get(node.getParentNode().getParentNode(), "@id-system");
			String name = XMLConfig.get(node.getParentNode(), "@id-channel");
			String nodeKey = sysName + "/" + name;
            String type = XMLConfig.get(node.getParentNode(), "@type");
            
            logger.debug("***********NODEKEY: " + nodeKey);
            logger.debug("***********TYPE: " + type);
			
            if (cryptDecryptType.equals(type)) {
            	logger.debug("********* INTO GESTPAYCryptDecryptAdapter ***********");
            	for (Entry<String, WSCryptDecrypt> e : cryptDecryptChannels.entrySet()) {
            		logger.debug("******** KEY: " + e.getKey() + "  NODEKEY: " + nodeKey);
            		if (e.getKey().equals(nodeKey)) {
            			wsCryptDecryp = e.getValue();
            		}
            	}
            	
            } else if (s2sType.equals(type)) {
            	for (Entry<String, WSs2S> e : s2sChannels.entrySet()) {
            		if (e.getKey().equals(nodeKey)) {
            			wss2s = e.getValue();
            		} 
            	}
            }
        	     
        } catch (Exception exc) {
            throw new InitializationException("GV_INIT_SERVICE_ERROR", new String[][]{{"message", exc.getMessage()}},
                    exc);
        }

    }
           

    @Override
    public GVBuffer perform(GVBuffer gvBuffer) throws ConnectionException, CallException, InvalidDataException {
       
        try {
	          if (gvBuffer.getObject()!=null) {
	        	  String data = (String) gvBuffer.getObject();
	        	  
	        	  if ("encrypt".equals(operation)) {
	        		  EncryptOperation encrypt = new EncryptOperation();
	        		  response = encrypt.encryptService(data, wsCryptDecryp);
	        	  }
	        	  
	        	  gvBuffer.setObject(response);
	          }
           
        } catch (Exception exc) {
            throw new CallException("GV_CALL_SERVICE_ERROR", new String[][]{{"service", gvBuffer.getService()},
                    {"system", gvBuffer.getSystem()}, {"tid", gvBuffer.getId().toString()},
                    {"message", exc.getMessage()}}, exc);
        }
        return gvBuffer;
    }    
   
    @Override
    public void cleanUp(){
        // do nothing
    }
    
    @Override
    public void destroy(){
        // do nothing
    }

    @Override
    public String getServiceAlias(GVBuffer gvBuffer){
        return gvBuffer.getService();
    }

    @Override
    public void setKey(OperationKey key){
        this.key = key;
    }
    
    @Override
    public OperationKey getKey(){
        return key;
    }
}
