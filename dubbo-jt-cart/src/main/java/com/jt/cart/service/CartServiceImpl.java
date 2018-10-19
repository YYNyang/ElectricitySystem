package com.jt.cart.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jt.cart.mapper.CartMapper;
import com.jt.dubbo.pojo.Cart;
import com.jt.dubbo.service.DubboCartService;

public class CartServiceImpl implements DubboCartService{
	@Autowired
	private CartMapper cartMapper;

	@Override
	public List<Cart> findCartListByUserId(Long userId) {
		Cart cart=new Cart();
		cart.setUserId(userId);
		return cartMapper.select(cart);
	}

	@Override
	public void saveCart(Cart cart) {
		Cart cartDB=cartMapper.findCartByUI(cart);
		if(cartDB==null) {
			//购物车没有新增
			cart.setCreated(new Date());
			cart.setUpdated(cart.getCreated());
			cartMapper.insert(cart);
		}else {
			//购物车有改变数量
			int num=cart.getNum()+cartDB.getNum();
			cartDB.setNum(num);
			cartMapper.updateByPrimaryKeySelective(cartDB);
		}
	}

	@Override
	public void deleteCart(Cart cart) {
		cartMapper.delete(cart);
	}

	@Override
	public void updateCart(Cart cart) {
		cart.setUpdated(new Date());
		cartMapper.updateCartNum(cart);
	}

	

}
