package controllers

import (
"github.com/revel/revel"
"fmt"
)
type App struct {
	*revel.Controller
}

func (c App) Index() revel.Result {
	
	fmt.Printf("You got to the App Controller")



	return c.Render()
}
