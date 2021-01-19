package tuwien.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tuwien.models.BlockChainConfig;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Value("${BLOCKCHAIN_HOST_WS}")
    private String blockChainHostWs;

    @Value("${BLOCKCHAIN_HOST_HTTP}")
    private String blockChainHostHttp;

    @Value("${BLOCKCHAIN_CONTRACT_ADDRESS}")
    private String contractAddress;

    @Value("${BLOCKCHAIN_ACCOUNT_PRIVATE_KEY}")
    private String privateAccountKey;


    @GetMapping("blockchain")
    public BlockChainConfig getBlockchainConfig() {
        BlockChainConfig config = new BlockChainConfig();
        config.setBlockChainAddressWS(blockChainHostWs);
        config.setBlockChainAddressHttp(blockChainHostHttp);
        config.setContractAddress(contractAddress);
        config.setPrivateAccountKey(privateAccountKey);
        return config;
    }
}
