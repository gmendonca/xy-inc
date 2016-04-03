'use strict';

/* https://github.com/angular/protractor/blob/master/docs/toc.md */

describe('my app', function() {


  it('should automatically create a top horizontall menu with a title, and three buttons', function() {
    browser.get('index.html');
    expect(element(by.id('zup-app-text')).getText()).toMatch(/Zup's App/);
    expect(element(by.id('zup-app-getproducts')).getText()).toMatch(/GetProducts/);
    expect(element(by.id('zup-app-getproduct')).getText()).toMatch(/GetProduct/);
    expect(element(by.id('zup-app-addproduct')).getText()).toMatch(/AddProduct/);
  });


  describe('GetProducts', function() {

    beforeEach(function() {
      browser.get('index.html#/getproducts');
    });


    it('should render getproducts when user navigates to /getproducts', function() {
      expect(element(by.id('zup-app-div-gproducts')).isPresent()).toMatch(true);
    });

  });


  describe('GetProduct', function() {

    beforeEach(function() {
      browser.get('index.html#/getproduct');
    });


    it('should render getproduct when user navigates to /getproduct', function() {
      expect(element(by.id('zup-app-div-gproduct')).isPresent()).toMatch(true);
    });

  });

  describe('AddProduct', function() {

    beforeEach(function() {
      browser.get('index.html#/addproduct');
    });


    it('should render addproduct when user navigates to /addproduct', function() {
      expect(element(by.id('zup-app-div-aproduct')).isPresent()).toMatch(true);
    });

  });

});
