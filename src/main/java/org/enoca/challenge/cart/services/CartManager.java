package org.enoca.challenge.cart.services;


import org.enoca.challenge.cart.dtos.request.CartRequestDto;
import org.enoca.challenge.cart.dtos.request.CartRowRequestDto;
import org.enoca.challenge.cart.dtos.response.CartResponseDto;
import org.enoca.challenge.cart.entities.Cart;
import org.enoca.challenge.cart.mappers.ICartMapper;
import org.enoca.challenge.cart.repositories.ICartRepository;
import org.enoca.challenge.core.services.GenericService;
import org.springframework.stereotype.Service;

@Service
public class CartManager extends GenericService<CartResponseDto, CartRequestDto, Cart, String, ICartMapper, ICartRepository> implements ICartService {

    private final ICartRowService cartRowService;

    public CartManager(ICartMapper mapper, ICartRepository repository, ICartRowService cartRowService) {
        super(mapper, repository);
        this.cartRowService = cartRowService;
    }

    @Override
    public CartResponseDto create(CartRequestDto requestDto) {
        return null;
    }

    @Override
    public Cart createCart() {

        var cart = new Cart();

        return repository.save(cart);
    }

    @Override
    public CartResponseDto update(String s, CartRequestDto requestDTO) {
        return null;
    }

    @Override
    public CartResponseDto addProductToCart(String cartId, CartRowRequestDto cartRowRequestDto) {

        var cart = getOneEntity(cartId);

        var cartRowList = cart.getCartRows();

        var cartRowResponse = cartRowService.create(cartRowRequestDto);

        var cartRow = cartRowService.getOneEntity(cartRowResponse.getId());

        cartRowList.add(cartRow);

        var savedCard = repository.save(cart);

        return mapper.toResponse(savedCard);
    }

    @Override
    public CartResponseDto emptyCart(String id) {
        return null;
    }

    @Override
    public CartResponseDto updateCartRow(String cartId, String rowId, CartRowRequestDto cartRowRequestDto) {
        return null;
    }
}
