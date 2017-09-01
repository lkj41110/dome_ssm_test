import React,{ Component } from 'react';
import { Menu, Icon, Spin } from 'antd';
import {Link} from 'react-router';
import styles from 'components/common/Common.less';

const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;

class Layout extends React.Component {
	render(){
		return (
			<div>
				<Menu mode="horizontal">
					<Menu.Item><Link to="/">主页</Link></Menu.Item>
				  <Menu.Item><Link to="/test2">子菜单项</Link></Menu.Item>
          <Menu.Item><Link to="/test2">子菜单项</Link></Menu.Item>
				</Menu>
				<div className={styles.content}>
					{this.props.children}
				</div>
			</div>
		)
	}
}

export default Layout;
