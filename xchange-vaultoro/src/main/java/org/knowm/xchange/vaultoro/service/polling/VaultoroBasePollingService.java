package org.knowm.xchange.vaultoro.service.polling;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.polling.BasePollingService;
import org.knowm.xchange.vaultoro.VaultoroAuthenticated;
import org.knowm.xchange.vaultoro.service.VaultoroDigest;

import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.RestProxyFactory;

public class VaultoroBasePollingService extends BaseExchangeService implements BasePollingService {

  protected final String apiKey;
  protected final VaultoroAuthenticated vaultoro;
  protected final ParamsDigest signatureCreator;

  /**
   * Constructor
   *
   * @param exchange
   */
  public VaultoroBasePollingService(Exchange exchange) {

    super(exchange);

    this.vaultoro = RestProxyFactory.createProxy(VaultoroAuthenticated.class, exchange.getExchangeSpecification().getSslUri());
    this.apiKey = exchange.getExchangeSpecification().getApiKey();
    this.signatureCreator = VaultoroDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());
  }

}
