import React,{Component} from 'react';
import connectToStores from 'alt-utils/lib/connectToStores';
import TestStore from 'stores/TestStore.js';
import TestAction  from 'actions/TestAction.js';
import Layout from 'components/common/Layout';
import {Button,Table} from 'antd';

const columns = [{
  title: 'Name',
  dataIndex: 'name',
  key: 'name',
  render: text => <a href="#">{text}</a>,
}, {
  title: 'Age',
  dataIndex: 'age',
  key: 'age',
}, {
  title: 'Address',
  dataIndex: 'address',
  key: 'address',
}];

class Test extends Component {

	static getStores(){
		return [TestStore]
	}

	static getPropsFromStores(){
		let state = TestStore.getState();
		console.log('Global State :',state)
		return {
      dataList: state.dataList,
      testState:state.testState
		}
	}

  componentDidMount() {
    TestAction.test();
  }

  handleGetData = () => {
    TestAction.getMoreData();
  }

  handleInitTest = (value) => {
    TestAction.initTest(value);
  }

	render(){
		return(
			<Layout>
        <br/>
        <Button type="primary" onClick={() => this.handleGetData()}>获取更多数据</Button>

        <Button type="primary" onClick={() => this.handleInitTest(this.props.testState)}>减少数据</Button>
        <br/>
        <Table columns={columns} dataSource={this.props.dataList} />
			</Layout>
		)
	}
}

export default connectToStores(Test);
